# Robson: Robot Framework speaks JSON

## Usage

1. Build and install robson-repl-VERSION.jar

```bash
cd repl/java
./mvnw clean install
cd ..
```

2. Build and install robotframework_robson-VERSION.whl

```bash
cd robotframework-robson
python -m build
pip install dist/robotframework_robson-VERSION.whl
cd ..
```

3. Build the Java keyword library

```bash
cd example/javalib
./mvnw clean package
cp target/javalib.jar ../lib/JavaLibrary/lib
cd ..
```

4. Execute the example Robot Framework test suite

```bash
robot -P lib test.robot
```
