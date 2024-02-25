# Robson: Robot Framework speaks JSON

## Usage

1. Build and install robson-VERSION.jar

```bash
cd java
./mvnw clean install
```

2. Build and install robotframework_robson-VERSION.whl

```bash
cd python
python -m build
pip install dist/robotframework_robson-VERSION.whl
```

3. Build the Java keyword library

```bash
cd examples/lib/JavaLibrary
./mvnw clean package
```

4. Execute the example Robot Framework test suite

```bash
robot -P lib test.robot
```
