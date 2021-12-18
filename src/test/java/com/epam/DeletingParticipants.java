package com.epam;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class DeletingParticipants {

    @Test
    public void deletingParticipantsDetails() {
        RequestSpecification httpsRequest = CommonFunctionality.getRequestSpecification();
        Response httpResponse = httpsRequest.request(Method.DELETE, "/participants/id/3036");
        CommonFunctionality.printingStatement("DeletingParticipants", httpResponse);
        CommonFunctionality.testingParticipantsData(httpResponse);

        //through response specification
        ResponseSpecBuilder resp=  new ResponseSpecBuilder();
        resp.expectStatusCode(200);
        resp.expectStatusLine("HTTP/1.1 200 ");
        resp.expectContentType(ContentType.JSON);

        ResponseSpecification responseSpecification=resp.build();

        httpsRequest.given()
                .spec(httpsRequest)
                .when().delete("/participants/id/3033").
                then().spec(responseSpecification).log().all();
    }

}
