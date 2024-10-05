package org.example.apitests.baseSpec;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.example.apitests.baseSpec.SpecBuilderPage.getRequestSpec;
import static org.example.apitests.baseSpec.SpecBuilderPage.getResponseSpec;

public class RestResource {

    public static Response post(String url, Object request) {

        return given(getRequestSpec()).
                body(request).
                relaxedHTTPSValidation().
                when().post(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String url) {

        return given(getRequestSpec()).
                relaxedHTTPSValidation().
                when().get(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
}
