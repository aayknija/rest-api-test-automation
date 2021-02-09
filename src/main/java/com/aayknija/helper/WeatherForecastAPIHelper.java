package com.aayknija.helper;

import com.aayknija.config.Configuration;
import com.aayknija.rest.RestCallerHelper;
import com.aayknija.rest.RestCallerHelperImpl;
import com.aayknija.utils.CommonConstants;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class WeatherForecastAPIHelper {

    private RestCallerHelper restCallerHelper= new RestCallerHelperImpl();

    public Response getWeatherForecast(String city){
        Map<String,String> params = new HashMap<>(1);
        params.put("q",city);
        Map<String,String> headers = new HashMap<>(2);
        headers.put(CommonConstants.API_KEY, Configuration.getInstance().getAPIKey());
        headers.put(CommonConstants.HOST, Configuration.getInstance().getWeatherAPIHost());
        String url = Configuration.getInstance().getWeatherApiBaseUrl() + "/weather";
        return restCallerHelper.callGetRequest(url,headers,params);
    }
}
