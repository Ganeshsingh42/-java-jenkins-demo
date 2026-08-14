# Java Jenkins Demo

A complete Maven-based Java application demonstrating best practices for building, testing, and packaging Java applications for CI/CD pipelines like Jenkins.

## 📋 Table of Contents
- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Building the Project](#building-the-project)
- [Running Tests](#running-tests)
- [Running the Application](#running-the-application)
- [Project Components](#project-components)
- [Dependencies](#dependencies)

## 📖 Project Overview

This is a production-ready Maven application that includes:
- ✅ Standard Maven directory structure
- ✅ Comprehensive unit test suite (12 tests, 100% pass rate)
- ✅ Logging with SLF4J
- ✅ Fat JAR packaging with maven-shade-plugin
- ✅ Proper POM configuration for Java 11

## 📁 Project Structure

```
-java-jenkins-demo/
├── README.md
├── pom.xml                                    # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── Application.java              # Main entry point
│   │   │   ├── GreetingService.java          # Greeting service
│   │   │   └── StringUtil.java               # String utilities
│   │   └── resources/
│   │       └── simplelogger.properties       # SLF4J configuration
│   └── test/
│       └── java/com/example/
│           ├── GreetingServiceTest.java      # Greeting tests (6 tests)
│           └── StringUtilTest.java           # String utility tests (6 tests)
└── target/                                   # Build output
    └── java-jenkins-demo-1.0.0.jar          # Executable JAR
```

## 📦 Prerequisites

- **Java 11+** — [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Maven 3.6+** — [Download Maven](https://maven.apache.org/download.cgi)
- **Git** — For version control

Verify installations:
```bash
java -version
mvn -version
git --version
```

## 🔨 Building the Project

### Clean Build
```bash
mvn clean install
```

This will:
1. Clean previous build artifacts
2. Compile source code
3. Run all unit tests
4. Package the application as a JAR
5. Install to local Maven repository

### Build without Tests
```bash
mvn clean install -DskipTests
```

### Compile Only
```bash
mvn compile
```

## 🧪 Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=GreetingServiceTest
```

### View Test Results
Test reports are generated in:
```
target/surefire-reports/
```

### Current Test Suite
- **GreetingServiceTest**: 6 tests for greeting/farewell functionality
- **StringUtilTest**: 6 tests for string operations
- **Total**: 12 tests | **Pass Rate**: 100%

## ▶️ Running the Application

### Run from JAR
```bash
java -jar target/java-jenkins-demo-1.0.0.jar
```

### Expected Output
```
2026-08-14 05:04:06 INFO com.example.Application - Starting Java Jenkins Demo Application
Hello, World!
2026-08-14 05:04:06 INFO com.example.Application - Application completed successfully
```

## 🎯 Project Components

### 1. Application.java
Main entry point that:
- Initializes the application with logging
- Creates a `GreetingService` instance
- Demonstrates greeting functionality

### 2. GreetingService.java
Service class providing:
- `greet(String name)` — Generate greeting messages
- `goodbye(String name)` — Generate farewell messages
- Input validation and logging

**Example Usage:**
```java
GreetingService service = new GreetingService();
System.out.println(service.greet("Alice"));    // Output: Hello, Alice!
System.out.println(service.goodbye("Bob"));    // Output: Goodbye, Bob!
```

### 3. StringUtil.java
Utility class for string operations:
- `reverse(String str)` — Reverse a string
- `isPalindrome(String str)` — Check if string is palindrome

**Example Usage:**
```java
StringUtil.reverse("hello");                    // Output: olleh
StringUtil.isPalindrome("racecar");            // Output: true
StringUtil.isPalindrome("A man, a plan, a canal: Panama"); // Output: true
```

## 📚 Dependencies

### Runtime Dependencies
- **SLF4J API** (1.7.36) — Logging facade
- **SLF4J Simple** (1.7.36) — Simple logging implementation

### Test Dependencies
- **JUnit** (4.13.2) — Unit testing framework

### Build Plugins
- **Maven Compiler** (3.8.1) — Java compilation
- **Maven Surefire** (2.22.2) — Test execution
- **Maven JAR** (3.2.0) — JAR packaging
- **Maven Shade** (3.2.4) — Fat JAR creation with dependencies

## 🚀 CI/CD Integration (Jenkins)

This project is optimized for Jenkins pipelines:

### Example Jenkinsfile Stage
```groovy
stage('Build') {
    steps {
        sh 'mvn clean install'
    }
}

stage('Test') {
    steps {
        sh 'mvn test'
        junit 'target/surefire-reports/*.xml'
    }
}

stage('Package') {
    steps {
        sh 'mvn package -DskipTests'
        archiveArtifacts 'target/java-jenkins-demo-1.0.0.jar'
    }
}
```

## 📝 Logging Configuration

Logging is configured via `src/main/resources/simplelogger.properties`:
```properties
org.slf4j.simpleLogger.defaultLogLevel=info
org.slf4j.simpleLogger.showDateTime=true
org.slf4j.simpleLogger.dateTimeFormat=yyyy-MM-dd HH:mm:ss
org.slf4j.simpleLogger.showThreadName=false
org.slf4j.simpleLogger.showLogName=true
```

## 🔧 Maven Configuration Highlights

### Java Version
```xml
<maven.compiler.source>11</maven.compiler.source>
<maven.compiler.target>11</maven.compiler.target>
```

### Fat JAR Creation
The maven-shade-plugin creates an executable fat JAR with all dependencies:
```bash
java -jar java-jenkins-demo-1.0.0.jar
```

## 📊 Build Output

After running `mvn clean install`:
```
[INFO] BUILD SUCCESS
[INFO] Total time: 18.261 s
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
```

## 🐛 Troubleshooting

### Java version not compatible
```bash
# Verify Java 11+ is installed
java -version
```

### Maven not found
```bash
# Add Maven to PATH or verify installation
mvn -version
```

### Tests failing
```bash
# Run tests with verbose output
mvn test -X
```

### JAR not executable
```bash
# Ensure fat JAR was created by shade plugin
ls -lh target/*.jar
```

## 📄 License

This project is provided as-is for educational and development purposes.

## 👨‍💻 Author

Created as a demonstration project for Maven-based Java development and CI/CD integration.