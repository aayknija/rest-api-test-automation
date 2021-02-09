package com.aayknija.rest;

import io.restassured.response.Response;

import java.util.Map;

public interface RestCallerHelper {

    /**
     * This method will execute the GET request for provided headers and params.
     *
     * @param url baseUrl.
     * @param headers headers.
     * @param params params.
     *
     * @return response.
     */
    Response callGetRequest(String url, Map<String,String> headers, Map<String,String> params);
}
