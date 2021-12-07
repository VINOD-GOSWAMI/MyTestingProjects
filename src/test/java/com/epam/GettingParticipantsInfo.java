package com.epam;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GettingParticipantsInfo {

    @Test
    public void gettingParticipants() {
        RequestSpecification httpsRequest = CommonFunctionality.getRequestSpecification();
        Response httpResponse = httpsRequest.request(Method.GET, "/participants/id/3329");
        CommonFunctionality.printingStatement("GettingParticipants", httpResponse);
        CommonFunctionality.testingParticipantsData(httpResponse);
    }

    @Test
    public void getParticipantsWhoseNameStartsWithPrefix() {

        RequestSpecification httpRequest = CommonFunctionality.getRequestSpecification();
        Response httpResponse = httpRequest.request(Method.GET, "/name/Tony");
        CommonFunctionality.printingStatement("Getting Participants Using Prefix", httpResponse);
        CommonFunctionality.testingParticipantsData(httpResponse);

    }

}
