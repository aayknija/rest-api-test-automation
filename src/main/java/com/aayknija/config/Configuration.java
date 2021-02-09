package com.aayknija.config;

import org.apache.commons.lang3.StringUtils;

public final class Configuration {

    private static final String WEATHER_API_BASE_URL = "https://community-open-weather-map.p.rapidapi.com";
    private static final String X_RAPID_API_KEY = "ENTER_YOUR_API_KEY";
    private static final String X_RAPID_WEATHER_API_HOST = "community-open-weather-map.p.rapidapi.com";
    private static Configuration instance;

    public static Configuration getInstance() {
        if(instance == null){
            instance = new Configuration();
        }
        return instance;
    }

    private Configuration() {

    }
    public String getWeatherApiBaseUrl() {
        String weatherApiBaseUrl = System.getenv().get("WEATHER_API_BASE_URL");
        if(StringUtils.isBlank(weatherApiBaseUrl)){
            weatherApiBaseUrl = WEATHER_API_BASE_URL;
        }
        return weatherApiBaseUrl;
    }

    public  String getAPIKey() {
        String apiKey = System.getenv().get("X_RAPID_API_KEY");
        if(StringUtils.isBlank(apiKey)){
            apiKey = X_RAPID_API_KEY;
        }
        return apiKey;
    }

    public  String getWeatherAPIHost() {
        String apiHost = System.getenv().get("X_RAPID_WEATHER_API_HOST");
        if(StringUtils.isBlank(apiHost)){
            apiHost = X_RAPID_WEATHER_API_HOST;
        }
        return apiHost;
    }
}
