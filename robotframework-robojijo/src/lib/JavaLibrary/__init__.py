from pathlib import Path
from os.path import realpath
from RoboJijo import RoboJijo

class JavaLibrary(RoboJijo):
    def __init__(self):
        cmd = ["java", "-jar", str(Path(realpath(__file__)).parent / "lib" / "javalib.jar")]
        super().__init__(cmd)
