package com.epam;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AddingParticipants {

    @Test(priority = 0)
    public void postRequest() {
        HashMap<String, Object> participantsValue = getStringObjectHashMap();
        JSONObject participantsValues = new JSONObject(participantsValue);

       RequestSpecification httpsRequest = CommonFunctionality.getRequestSpecification();
        httpsRequest.contentType(ContentType.JSON);
        httpsRequest.body(participantsValues.toJSONString());
        httpsRequest.accept(ContentType.JSON);
        Response httpResponse = httpsRequest.post("/participants");

        CommonFunctionality.printingStatement("AddingParticipants", httpResponse);
        CommonFunctionality.testingParticipantsData(httpResponse);

    }

    private HashMap<String, Object> getStringObjectHashMap() {
        HashMap<String, Object> participantsValue = new HashMap<>();
        participantsValue.put("batchId", 28);
        participantsValue.put("batchName", "Testings");
        participantsValue.put("collegeId", 306);
        participantsValue.put("collegeName", "IIIT");
        participantsValue.put("comments", "no comment");
        participantsValue.put("gender", "Male");
        participantsValue.put("isFaculty", true);
        participantsValue.put("mobile", 6775384444L);
        participantsValue.put("participantEmail", "ironman@gmail.com");
        participantsValue.put("participantName", "Tony Stark");
        participantsValue.put("status", "Active");
        return participantsValue;
    }

    @Test(priority = 1)
    public void addingParticipantsPojo() throws JsonProcessingException {
        RequestSpecification httpRequest = CommonFunctionality.getRequestSpecification();

        httpRequest.header("Content-Type", "application/json");
        ParticipantPojo participantDetails = new ParticipantPojo();
        participantDetails.setParticipantId("435");
        participantDetails.setBatchId("28");
        participantDetails.setBatchName("Testing");
        participantDetails.setCollegeId("306");
        participantDetails.setCollegeName("IIIT");
        participantDetails.setMobile("8138632469");
        participantDetails.setParticipantEmail("weekend@epam.com");
        participantDetails.setGender("Male");
        participantDetails.setIsFaculty("true");
        participantDetails.setParticipantName("Weekend");
        participantDetails.setStatus("Active");
        httpRequest.body(participantDetails);

    //    Response httpResponse = httpRequest.request(Method.POST, "/participants");

//through response specification
        ResponseSpecBuilder resp=  new ResponseSpecBuilder();
        resp.expectStatusCode(201);
        resp.expectStatusLine("HTTP/1.1 201 ");
        resp.expectContentType(ContentType.JSON);

        ResponseSpecification responseSpecification=resp.build();

        httpRequest.given()
                .spec(httpRequest)
                .when().post("/participants").
                then().spec(responseSpecification).log().all();

 //       CommonFunctionality.testingParticipantsData(httpResponse);
//        CommonFunctionality.printingStatement("adding using Participant pojo", httpResponse);
    }

}
