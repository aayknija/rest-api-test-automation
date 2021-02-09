package com.aayknija.rest;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestCallerHelperImpl implements RestCallerHelper {

    @Override
    public Response callGetRequest(String url, Map<String,String> headers, Map<String, String> params ) {
        RequestSpecification requestSpecification = given()
                .relaxedHTTPSValidation()
                .config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation()))
                .log()
                .all();
        if(params != null && !params.keySet().isEmpty()){
            requestSpecification.queryParams(params);
        }
        if(headers != null && !headers.keySet().isEmpty()){
            requestSpecification.headers(headers);
        }
        return requestSpecification.when()
                .get(url)
                .then()
                .log()
                .all()
                .extract()
                .response();

    }
}
