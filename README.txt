Runs all tests in parallel in 10 thread, each test is run 20 times
    mvn clean test -DthreadPoolSize=10 -DinvocationCount=20

Open target/surefire-reports/html/index.html for reports.
