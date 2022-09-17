import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import org.hamcrest.comparator.ComparatorMatcherBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class LongtimeJobTest {

    @Test
    public void testLongtimeJob() throws InterruptedException {
        // step1
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/longtime_job")
                .jsonPath();

        response.prettyPrint();
        String tokenHeader = response.get("token");
        System.out.println(tokenHeader);
        Integer timeDelay = response.get("seconds");
        System.out.println(timeDelay);


        //step2
        Map<String, String> params = new HashMap<>();
        params.put("token", tokenHeader);
        Thread.sleep(timeDelay * 1000);

        JsonPath response1 = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/longtime_job")
                .jsonPath();

        response1.prettyPrint();
        String result = response1.get("result");
        String status = response1.get("status");

        Assertions.assertNotEquals(null, result);

        String example = "Job is ready";
        Assertions.assertEquals(example, status);

    }

}
