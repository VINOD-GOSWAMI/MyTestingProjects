package com.epam;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

public class UpdatingParticipants {

    @Test
    public void updatingParticipantsDetails() {

        RestAssured.baseURI = "http://epinhydw0087:9090/programs";
        RequestSpecification httpsRequest = RestAssured.given();
        httpsRequest.header("content-type", "application/json");
        HashMap<String, Object> request = new HashMap<>();
        request.put("batchId", "28");
        request.put("batchName", "Testings");
        request.put("collegeId", "306");
        request.put("collegeName", "IIIT");
        request.put("gender", "Male");
        request.put("isFaculty", "true");
        request.put("participantEmail", "captianAmerica@epam.com");
        request.put("participantName", "Captain America");
        request.put("status", "ACTIVE");
        request.put("comments", "no comment");

        JSONObject participantUpdation = new JSONObject(request);

        httpsRequest.body(participantUpdation.toJSONString());

        Response httpResponse = httpsRequest.request(Method.PUT, "/participants/id/13323");
        CommonFunctionality.printingStatement("UpdatingParticipants", httpResponse);
        CommonFunctionality.testingParticipantsData(httpResponse);
    }

}
