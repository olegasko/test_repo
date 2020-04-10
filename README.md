1. To prepare test execution
    - cd ui//src/test/java/ggr
    - docker-compose up --build -d
    - docker run -d selenoid/vnc_chrome:80.0
    - docker run -d selenoid/video-recorder:latest-release
2. To run tests
    - cd ui
    - mvn clean test
2. To generate allure report
    - cd ui 
    - mvn site
3. Already implemented
    - cucumber demo features
    - local run for webdriver (Selenide framework)
    - allure reporting
    - parallel test run
    - screenshots in report
    - link on JIRA ticket in report
    - run tests in Docker container (to integrate in pipeline)
4. To do
    - integration with backend
    - add video in report
    - tool to estimate coverage