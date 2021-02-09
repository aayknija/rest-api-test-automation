package com.aayknija.stepDefinitions;

import com.aayknija.helper.WeatherForecastAPIHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class WeatherForecastSteps {

    private final WeatherForecastAPIHelper weatherForecastAPIHelper = new WeatherForecastAPIHelper();
    private String city = null;
    private Response weatherForeCastResponse = null;

    @Given("I have city name {string}")
    public void i_have_city_name(String city) {
        this.city = city;
        Assert.assertNotNull(city);
    }

    @When("I do call to weather forecast api for current weather")
    public void i_do_call_to_weather_forecast_api_for_current_weather() {
        weatherForeCastResponse = weatherForecastAPIHelper.getWeatherForecast(city);
    }

    @Then("I receive current weather forecast for {string}")
    public void i_receive_current_weather_forecast_for(String string) {
        Assert.assertNotNull(weatherForeCastResponse);
        String cityName = weatherForeCastResponse.getBody().jsonPath().getString("name");
        Assert.assertEquals(city,cityName);
        String weather = weatherForeCastResponse.getBody().jsonPath().getString("weather");
        Assert.assertNotNull(weather);
    }
}
