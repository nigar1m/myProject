package actions;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private static final Logger log = LogManager.getLogger(ApiTest.class);

    public Response getApiResponse(String url) {
        return given()
                .when()
                .get(url)
                .then()
                .log().ifError()
                .statusCode(200)
                .log().body()
                .extract()
                .response();

    }

    public Response postApiRequest(String url, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .log().ifError()
                .statusCode(201)
                .log().body()
                .extract()
                .response();
    }

    public Response putApiRequest(String url, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(url)
                .then()
                .log().ifError()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }

    public Response deleteApiRequest(String url) {
        return given()
                .when()
                .delete(url)
                .then()
                .log().ifError()
                .statusCode(204)
                .log().body()
                .extract()
                .response();
    }

    public Response patchApiRequest(String url, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .patch(url)
                .then()
                .log().ifError()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }

    public void validateResponse(Response response, int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        if (actualStatusCode != expectedStatusCode) {
            log.info("Expected status code: {}, but got: {}", expectedStatusCode, actualStatusCode);
        }
        assert actualStatusCode == expectedStatusCode : "Status code mismatch!";
    }
}
