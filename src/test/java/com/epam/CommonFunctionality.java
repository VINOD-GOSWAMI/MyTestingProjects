package com.epam;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

public class CommonFunctionality {
    private static final Logger logger = LogManager.getLogger(CommonFunctionality.class);

    public static RequestSpecification getRequestSpecification() {
        RestAssured.baseURI = "http://epinhydw0087:9090/programs";
        RequestSpecification httpsRequest = RestAssured.given();
        return httpsRequest;
    }

    public static void testingParticipantsData(Response httpResponse) {
        SoftAssert softAssert = new SoftAssert();
        if (httpResponse.statusCode() == 201) {
            softAssert.assertEquals(httpResponse.getStatusCode(), 201);
            softAssert.assertEquals(httpResponse.getStatusLine(), "HTTP/1.1 201 ");
        } else {
            softAssert.assertEquals(httpResponse.getStatusCode(), 200);
            softAssert.assertEquals(httpResponse.getStatusLine(), "HTTP/1.1 200 ");
        }
        softAssert.assertEquals(httpResponse.getContentType(), "application/json");
        softAssert.assertAll();
    }

    public static void printingStatement(String methodName, Response httpResponse) {
        logger.info("method used {} and response body {}", methodName, httpResponse.prettyPrint());
        logger.info("method used {} and response status code  {}", methodName, httpResponse.statusCode());
        logger.info("method used {} and response content type  {}", methodName, httpResponse.getContentType());
        logger.info("method used {} and response status line  {}", methodName, httpResponse.getStatusLine());
    }
}
