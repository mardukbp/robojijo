import json
import sys

from itertools import count
from subprocess import Popen, PIPE, STDOUT
from typing_extensions import List

from robot.errors import RemoteError
from robot.libraries.Remote import RemoteResult


class DynamicLibrary(object):
    def __init__(self, cmd: List[str]):
        self.args = cmd
        self.repl = self._repl
        self.counter = count(1)

    @property
    def _repl(self):
        return self._start_repl(self.args)

    def _start_repl(self, args: List[str]):
        return Popen(
            args,
            stdout=PIPE,
            stdin=PIPE,
            stderr=STDOUT,
            bufsize=1,
            universal_newlines=True,
            encoding="utf-8"
        )

    def __del__(self):
        self.repl.terminate()

    def _send_request(self, method: str, args: List[str]):
        request = {
            "jsonrpc": "2.0",
            "method": method,
            "params": args,
            "id": next(self.counter)
        }

        assert self.repl.stdout is not None
        assert self.repl.stdin is not None

        self.repl.stdin.write(json.dumps(request) + '\n')
        response = self.repl.stdout.readline()

        try:
            return json.loads(response)
        except Exception:
            raise RemoteError(response)

    def get_keyword_names(self) -> List[str]:
        return self._send_request("get_keyword_names", [])["result"]

    def get_keyword_arguments(self, keyword) -> List[str]:
        return self._send_request("get_keyword_arguments", [keyword])["result"]

    def get_keyword_types(self, keyword) -> List[str]:
        return self._send_request("get_keyword_types", [keyword])["result"]

    def get_keyword_documentation(self, keyword) -> str:
        return self._send_request("get_keyword_documentation", [keyword])["result"]

    def run_keyword(self, name: str, args: List[str]): # type: ignore
        json_response = self._send_request("run_keyword", [name, *args])

        if "result" in json_response:
            rf_result = RemoteResult(json_response["result"])
        else:
            rf_result = RemoteResult(json_response["error"]["data"])

        if rf_result.status != "PASS": # type: ignore
            raise RemoteError(
                rf_result.error,
                rf_result.traceback,
                rf_result.fatal,
                rf_result.continuable
            )

        sys.stdout.write(rf_result.output)
        return rf_result.return_ # type: ignore

    ROBOT_LIBRARY_SCOPE = 'SUITE'
