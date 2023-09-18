# RoboJiJo: Robot Framework's dynamic API over JSON

## Usage

1. Build and install robojijo-java-VERSION.jar

```bash
cd robojijo-java
./mvnw clean install
cd ..
```

2. Build and install robotframework_robojijo-VERSION.whl

```bash
cd robotframework-robojijo
python -m build
pip install dist/robotframework_robojijo-VERSION.whl
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
