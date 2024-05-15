from pathlib import Path
import click
import os
import shutil


package_path = Path(os.path.abspath(__file__)).parent


@click.group()
@click.version_option(package_name="robotframework_robson", prog_name='robson')
def cli():
    """
    robson helps with getting started writing RF libraries in other programming languages
    """
    pass


@cli.command('init.java', short_help='Initialize a Java library project')
def init_java():
    template_path = os.path.abspath(package_path / "templates/Java Template.zip")
    shutil.unpack_archive(template_path, os.getcwd())
