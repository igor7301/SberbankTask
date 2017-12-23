# SberbankTask

### Run test via maven:


##### Windows + Chrome browser
```
mvn clean integration-test -Dit.test=Sberbank_Tests -Dexpected.browser=Chrome -Dwebdriver.chrome.driver=chromedriver.exe
```

##### MAC + Chrome browser
```
mvn clean integration-test -Dit.test=Sberbank_Tests -Dexpected.browser=Chrome -Dwebdriver.chrome.driver=chromedriver_mac
```

##### Windows + Firefox browser
```
mvn clean integration-test -Dit.test=Sberbank_Tests -Dexpected.browser=Firefox -Dwebdriver.gecko.driver=geckodriver.exe
```

##### MAC + Firefox browser
```
mvn clean integration-test -Dit.test=Sberbank_Tests -Dexpected.browser=Firefox -Dwebdriver.gecko.driver=geckodriver_mac
```


### Generate an allure report:
```
mvn site
```

### Allure results will be here:
```
/target/site/allure-maven-plugin/index.html
```




