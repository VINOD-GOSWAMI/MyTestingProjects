package com.epam;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class GettingParticipantsInfo {

    @Test
    public void gettingParticipants() {
        RequestSpecification httpsRequest = CommonFunctionality.getRequestSpecification();
        Response httpResponse = httpsRequest.request(Method.GET, "/participants/id/3329");
        CommonFunctionality.printingStatement("GettingParticipants", httpResponse);
        CommonFunctionality.testingParticipantsData(httpResponse);

        ResponseSpecBuilder resp=  new ResponseSpecBuilder();
                resp.expectStatusCode(200);
                resp.expectStatusLine("HTTP/1.1 200 ");
                resp.expectContentType(ContentType.JSON);

                ResponseSpecification responseSpecification=resp.build();

        httpsRequest.given()
                .spec(httpsRequest)
                .when().get("/participants/id/3329").
                then().spec(responseSpecification);
    }

    @Test
    public void getParticipantsWhoseNameStartsWithPrefix() {

        RequestSpecification httpRequest = CommonFunctionality.getRequestSpecification();
        Response httpResponse = httpRequest.request(Method.GET, "/name/Tony");

        CommonFunctionality.printingStatement("Getting Participants Using Prefix", httpResponse);
        CommonFunctionality.testingParticipantsData(httpResponse);

        //through response specification
        ResponseSpecBuilder resp=  new ResponseSpecBuilder();
        resp.expectStatusCode(200);
        resp.expectStatusLine("HTTP/1.1 200 ");
        resp.expectContentType(ContentType.JSON);

        ResponseSpecification responseSpecification=resp.build();

        httpRequest.given()
                .spec(httpRequest)
                .when().get("/name/Tony").
                then().spec(responseSpecification).log().all();

    }

}
