# Robson: JSON-RPC-based dynamic library interface for Robot Framework

Call Robot Framework keywords implemented in other programming languages through JSON-RPC.

## How to use it

1. Install the package

```bash
pip install robotframework-robson
```

2. Create a library using one of the provided templates.

For example, to create a Java library execute:

```bash
robson init.java
```

Hint: In case your environment does not allow executing `robson`, call the Python module directly:

```bash
python -m Robson init.java
```

3. Implement your own keywords and compile the library.

See the documentation included in the library created from the template.


## How does it work

Robson consists of two parts. A keyword library is implemented in another programming language exposed as a REPL that accepts JSON as input. The REPL is available as a library on the programming language's package repository. On the Python side, a thin wrapper starts the REPL and communicates with it using JSON-RPC messages. This is the functionality provided by this package.
