/**
 * Created by 1 on 10.04.2018.
 */

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.json.JSONObject;
import static io.restassured.RestAssured.preemptive;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestAuth {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";
    private static final String URL= "https://diploma-courses.7bits.it";

    @Before
    public void setUp() {
        RestAssured.baseURI = URL;
        RestAssured.basePath = "/api";
        RestAssured.authentication = preemptive().basic(USERNAME, PASSWORD);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static ValidatableResponse postJson(String request, String url, int status) {
        return given()
                .contentType(ContentType.JSON)
                .body(request)
            .when()
                .post(url)
            .then()
                .statusCode(status);
    }

    @Test
    public void testRight() {
        LoginRequestData requestData= new LoginRequestData("admin", "admin");
        ValidatableResponse resp =  postJson(new Gson().toJson(requestData), "/login", 200);
        resp.body("token", is(notNullValue()));
    }

    @Test
    public void testEmptyLogin() {
        LoginRequestData requestData= new LoginRequestData("", "admin");
        ValidatableResponse resp =  postJson(new Gson().toJson(requestData), "/login", 403);
        resp.body("Token", is(nullValue()));
    }

    @Test
    public void testEmptyPassword() {
        LoginRequestData requestData= new LoginRequestData("admin", "");
        JSONObject jo = new JSONObject();
        ValidatableResponse resp =  postJson(new Gson().toJson(requestData), "/login", 403);
        resp.body("Token", is(nullValue()));
    }

    @Test
    public void testWrongPassword() {
        LoginRequestData requestData= new LoginRequestData("admin", "a");
        ValidatableResponse resp =  postJson(new Gson().toJson(requestData), "/login", 403);
        resp.body("Token", is(nullValue()));
    }

}

