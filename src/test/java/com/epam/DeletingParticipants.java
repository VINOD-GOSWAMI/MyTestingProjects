package com.epam;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeletingParticipants {

    @Test
    public void deletingParticipantsDetails() {
        RequestSpecification httpsRequest = CommonFunctionality.getRequestSpecification();
        Response httpResponse = httpsRequest.request(Method.DELETE, "/participants/id/13324");
        CommonFunctionality.printingStatement("DeletingParticipants", httpResponse);
        CommonFunctionality.testingParticipantsData(httpResponse);
    }
}
