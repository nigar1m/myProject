package tests;

import actions.ApiTest;
import data.TestData;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTestsSample {
    ApiTest apiTest = new ApiTest();
    String baseUrl;

    @BeforeClass
    public void setUp() {
        baseUrl = TestData.getTestData("baseUrl");
    }

    @Test
    public void testGetApiResponse() {
        String endPoint = TestData.getTestData("getApiEndpoint");
        String url = baseUrl + endPoint;
        Response response = apiTest.getApiResponse(url);
        apiTest.validateResponse(response, 200);
    }

    @Test
    public void testPostApiRequest() {
        String endPoint = TestData.getTestData("postApiEndpoint");
        String url = baseUrl + endPoint;
        String requestBody = "{\"name\":\"Nigar\", \"job\":\"developer\"}";
        Response response = apiTest.postApiRequest(url, requestBody);
        apiTest.validateResponse(response, 201);

    }

    @Test
    public void testPutApiRequest() {
        String endPoint = TestData.getTestData("putApiEndpoint");
        String url = baseUrl + endPoint;
        String requestBody = "{\"name\":\"Nigar\", \"job\":\"senior developer\"}";
        Response response = apiTest.putApiRequest(url, requestBody);
        apiTest.validateResponse(response, 200);
    }

    @Test
    public void testDeleteApiRequest() {
        String endPoint = TestData.getTestData("deleteApiEndpoint");
        String url = baseUrl + endPoint;
        Response response = apiTest.deleteApiRequest(url);
        apiTest.validateResponse(response, 204);
    }
    @Test
    public void testPatchApiRequest() {
        String endPoint = TestData.getTestData("patchApiEndpoint");
        String url = baseUrl + endPoint;
        String requestBody = "{\"job\":\"lead developer\"}";
        Response response = apiTest.patchApiRequest(url, requestBody);
        apiTest.validateResponse(response, 200);
    }
}
