# Examples of using Robson

## Requirements

Install `robotframework-robson`:

```python
pip install -f . robotframework-robson
```

## Defining keywords

Keywords are the methods of a class that have the annotations:

- `@Keyword`: allows specifying a name in a language other than English
- `@Doc`: tells the user how to use and what to expect from the keyword

Keyword arguments with the following Java types are automatically converted:

- int, int[], int[][]
- double, double[], double[][]
- String, String[], String[][]
- Map<String, Integer>, Map<String, String>, Map<String, Double>, Map<String, Boolean>
- boolean

Any other argument must have type `Object` and requires manual conversion within the keyword.

## Executing tests with RobotCode (VS Code extension)

If RobotCode cannot find a library, make sure that the setting `robotPythonPath` includes the path to the library.

After updating a library RobotCode might fail to recognize the changes in the keyword signatures.
To force it to reindex the library execute the following command in VS Code: 

```
RobotCode: Clear Cache and Restart Language Servers
```

## Executing tests with robot

When executing `robot` make sure to use the parameter `-P` to add the path to the library to PYTHONPATH.
