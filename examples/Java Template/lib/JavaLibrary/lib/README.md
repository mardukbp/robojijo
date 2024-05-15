# JavaLibrary

The Java keywords are implemented in the class `JavaLibrary` defined in

```
src/main/java/org/example/JavaLibrary.java
```

## Defining keywords

Keywords are the methods of a subclass of `rf.robson.robotframework.RobotLibrary` that have the annotations:

- `@Keyword`: allows specifying a name in a language other than English
- `@Doc`: tells the user how to use and what to expect from the keyword

`rf.robson.robotframework.RobotLibrary` is provided by the Maven package [robotframework-robson](https://central.sonatype.com/artifact/io.github.mardukbp/robotframework-robson).

Keyword arguments with the following Java types are automatically converted
to Python types:

- int, int[], int[][]
- double, double[], double[][]
- String, String[], String[][]
- Map<String, Integer>, Map<String, String>, Map<String, Double>, Map<String, Boolean>
- boolean

Any other argument must have type `Object` and requires manual conversion (e.g. type casting) within the keyword.


## Build the Java library with the JDK only

Add the .jar dependencies to the `deps` directory and to the `MANIFEST.MF` file.

Build javalib.jar (which searches for its dependencies in the `deps` directory):

```bash
.\build.bat
```


## Build the Java library With Maven

In order to build javalib.jar (which includes all its dependencies) execute:

```bash
mvn package
```


## Library and Keyword documentation

Using JDK 17 is recommended because this version of Java supports text blocks (delimited by triple double-quotes), just like Python.

It is possible to add formatting to the documentation (bold text, code, links, tables, headings). See the [RF documentation syntax](https://robotframework.org/robotframework/latest/RobotFrameworkUserGuide.html#inline-styles).
