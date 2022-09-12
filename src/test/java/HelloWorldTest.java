import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;


public class HelloWorldTest {

    @Test

    public void testHelloWorld(){
       Response response = RestAssured
               .get("https://playground.learnqa.ru/api/get_text")
               .andReturn();
      // response.prettyPrint();
        System.out.println(response.asString());
    }
}
