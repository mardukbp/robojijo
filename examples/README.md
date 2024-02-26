# Examples of using Robson

## Requirements

Install `robotframework-robson`:

```python
pip install robotframework-robson
```

## Defining keywords

Keywords are methods of a class that have the annotations `@Keyword`, which allows specifying a name in a language other than English, and `@Doc`, which tells the user how to use and how to expect from the keyword.

## Supported keyword argument types

The keywords that can be called using Robson can only have arguments with one of the following types:

- int
- float (or double)
- string
- boolean

Since lists and maps can be arbitrarily nested, they must be passed as JSON strings. The keyword is responsible for parsing the JSON into the corresponding data structure.

Correspondingly, lists and maps can only be returned as a JSON string. It can be parsed using the [JSONLibrary](https://robotframework-thailand.github.io/robotframework-jsonlibrary/JSONLibrary.html).


## Executing tests with RobotCode (VS Code extension)

If RobotCode cannot find a library, make sure that the setting `robotPythonPath` includes the path to the library.

After updating a library RobotCode might fail to recognize the changes in the keyword signatures.
To force it to reindex the library execute the following command in VS Code: 

```
RobotCode: Clear Cache and Restart Language Servers
```

## Executing tests with robot

When executing `robot` make sure to use the parameter `-P` to add the path to the library to PYTHONPATH.
