import io.restassured.path.json.JsonPath;
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
        JsonPath response = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();

        String name = response.get("answer1");
        if (name == null){
            System.out.println("Are you kidding me?");
        } else {
            System.out.println(name);
        }
    }
}
