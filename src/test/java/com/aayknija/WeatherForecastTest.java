package com.aayknija;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/SystemTest/html"
                ,"json:target/SystemTest/json/system-test-result.json"},
        features = "src/test/resources",
        glue = "com.aayknija.stepDefinitions")
public class WeatherForecastTest {
}
