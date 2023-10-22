package com.gedha;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/main/resources/features/loginSauceDemo.feature",
                "src/main/resources/features/CheckoutSauceDemo.feature"
        },
        glue = "com.gedha",
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"}
)
public class RunnterTest extends AbstractTestNGCucumberTests {


}
