# robotframework-robson

JSON REPL for exposing a Java library to Robot Framework using the RF Dynamic API

## Examples

```json
{"id": 1, "jsonrpc": "2.0", "method": "run_keyword", "params": ["Get Full Name", "john", "doe"]}
```

```json
{"id": 1, "jsonrpc": "2.0", "method": "get_keyword_arguments", "params": ["Get Full Name"]}
```

```json
{"id": 1, "jsonrpc": "2.0", "method": "get_keyword_names", "params": []}
```

```json
{"id": 1, "jsonrpc": "2.0", "method": "get_keyword_documentation", "params": ["__intro__"]}
```
