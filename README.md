# Introduction

This is a test project that demonstrates unexpected behaviour I saw in my prod code.
That behaviour was a test failing both in my IDE (IntelliJ) as well as Maven but the Maven build was not stopped.

# Running

1. Note that the test `FailingZIOTest` fails if you remove `@ignore`.
1. Re-instate `maven-surefire-plugin` in the top level `pom.xml`. 
1. Build this project with `mvn clean install`
1. Note that all tests run and `FailingZIOTest` outputs:
```
+ Not expecting any errors here
  + 11 == 11, right?
Ran 1 test in 74 ms: 1 succeeded, 0 ignored, 0 failed
- Naughty test
  - 11 != 12, and I damn well know it
    11 did not satisfy equalTo(12)
Ran 1 test in 31 ms: 0 succeeded, 0 ignored, 1 failed

```
but the build goes on to:
```
[INFO] BUILD SUCCESS
```
# Solution

Do not use `maven-surefire-plugin` in `pom.xml`. However, this will ignore ZIO tests so be sure to annotate
your test with `@RunWith(classOf[ZTestJUnitRunner])`

Note that as a consequence of this, your ZIO tests should end with `Test` and your ScalaTests with `Spec`.