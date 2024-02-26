## JavaLibrary

The Java keywords are implemented in the class `JavaLibrary` defined in

```bash
src/main/java/org/example/JavaLibrary.java
```

## Build the Java library With Maven

In order to build javalib.jar (which includes all its dependencies):

```bash
mvn package
```

## Build the Java library with the JDK only

Add the .jar dependencies to the `deps` directory and to the `MANIFEST.MF` file.

Build javalib.jar (which searches for its dependencies in the `deps` directory):

```bash
.\build.bat
```

## Library and Keyword documentation

Using JDK 17 is recommended because this version of Java supports text blocks (delimited by triple double-quotes), just like Python.

It is possible to add formatting to the documentation (bold text, code, links, tables, headings). See the [RF documentation syntax](https://robotframework.org/robotframework/latest/RobotFrameworkUserGuide.html#inline-styles).
