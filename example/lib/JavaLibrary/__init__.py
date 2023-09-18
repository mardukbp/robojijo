from os.path import realpath
from pathlib import Path
from robojijo import RoboJiJo


class JavaLibrary(RoboJiJo):
    def __init__(self):
        jar = str(Path(realpath(__file__)).parent / "lib" / "javalib.jar")
        cmd = ["java", "-jar", jar]
        super().__init__(cmd)
