/**
 * Created by 1 on 10.04.2018.
 */

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import org.json.JSONObject;
import com.jayway.restassured.response.Response;

public class TestAuth {

    public static ValidatableResponse postJson(JSONObject request, String url, int status) {
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
        JSONObject jo = new JSONObject();
        jo.put("login", "admin");
        jo.put("password", "admin");
        Response resp = new postJson(jo, "https://diploma-courses.7bits.it/login", 200);
        Assert.assertNotNull(resp.body());
    }

    @Test
    public void testEmptyLogin() {
        JSONObject jo = new JSONObject();
        jo.put("login", "");
        jo.put("password", "admin");
        Response resp = new postJson(jo, "https://diploma-courses.7bits.it/login", 200);
        Assert.assertNull(resp.body());
    }

    @Test
    public void testEmptyPassword() {
        JSONObject jo = new JSONObject();
        jo.put("login", "admin");
        jo.put("password", "");
        Response resp = new postJson(jo, "https://diploma-courses.7bits.it/login", 200);
        Assert.assertNull(resp.body());
    }

    @Test
    public void testWrongPassword() {
        JSONObject jo = new JSONObject();
        jo.put("login", "admin");
        jo.put("password", "a");
        Response resp = new postJson(jo, "https://diploma-courses.7bits.it/login", 200);
        Assert.assertNull(resp.body());
    }

}
