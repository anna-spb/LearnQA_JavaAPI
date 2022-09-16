import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;


public class HelloWorldTest {

    @Test

    public void testRestAssured() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Anna");
        Response response = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello")
                .andReturn();
        response.prettyPrint();
        // System.out.println(response.asString());
    }
}
