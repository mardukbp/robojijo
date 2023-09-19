#!/usr/bin/env python

from setuptools import setup

setup(
    name='robotframework-robson',
    version='1.0',
    author='Marduk Bolaños',
    maintainer='Marduk Bolaños',
    maintainer_email='mardukbp@mac.com',
    url='https://github.com/mardukbp/robson',
    license='Apache 2',
    package_dir={'': 'src'},
    packages=['robson'],
    install_requires=[
        'robotframework>=5.0.1',
    ],
    python_requires='>=3.8'
)