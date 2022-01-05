package com.epam.api_data;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class ApiTesting {
    public Response gettingResponseWithName(String participantName) {
        RestAssured.baseURI = "http://epinhydw0087:9090/programs";
        RequestSpecification httpsRequest = RestAssured.given();
        Response httpResponse = httpsRequest.request(Method.GET, "/participants/name/" + participantName + "");
        httpResponse.prettyPrint();
        return httpResponse;
    }

    public Response gettingResponseWithEmail(String participantEmail) {
        RestAssured.baseURI = "http://epinhydw0087:9090/programs";
        RequestSpecification httpRequest = RestAssured.given();
        Response httpResponse = httpRequest.request(Method.GET, "/participants/email/" + participantEmail + "");
        httpResponse.prettyPrint();
        return httpResponse;

    }
}
