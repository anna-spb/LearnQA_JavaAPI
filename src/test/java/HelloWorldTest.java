import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;


public class HelloWorldTest {

    @Test

    public void testRestAssured() {
        Map<String, String> headers = new HashMap<>();
        headers.put("header1", "value1");
        headers.put("header2", "value2");
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();

        response.prettyPrint();
        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);
    }
}

