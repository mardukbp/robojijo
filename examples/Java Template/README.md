# Calling a Java library from Robot Framework

The example Java library `JavaLibrary` is located in the `lib` directory.
It can be used as a starting point for implementing your own library.

In order to use the library it has to be compiled first. Execute the `build` script provided in `lib/JavaLibrary/lib`. It requires JDK 8.

The test suite in `test.robot` calls the keywords provided by this library. The failing tests show that RF performs type checking before calling the keywords.

## Executing tests with RobotCode (VS Code extension)

Open this directory in VS Code.

If RobotCode cannot find the library, make sure that the setting `robotPythonPath` includes the path to the library.

After updating the library RobotCode might fail to recognize the changes in the keyword signatures. To force it to reindex the library execute the following command in VS Code: 

```
RobotCode: Clear Cache and Restart Language Servers
```

## Executing tests with robot

When executing `robot` make sure to use the parameter `-P` to add the path to the library to PYTHONPATH. For example,

```bash
robot -P lib test.robot
```
