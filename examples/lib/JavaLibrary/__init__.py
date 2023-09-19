from os.path import realpath
from pathlib import Path
from robson import DynamicLibrary


class JavaLibrary(DynamicLibrary):
    def __init__(self):
        jar = str(Path(realpath(__file__)).parent / "lib" / "javalib.jar")
        cmd = ["java", "-jar", jar]
        super().__init__(cmd)
