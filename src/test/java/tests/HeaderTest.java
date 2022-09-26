package tests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HeaderTest {

    @Test
    public void testHeader() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();


        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);

        String secretHeader = response.getHeader("x-secret-homework-header");
        System.out.println(secretHeader);


        assertEquals("Some secret value", secretHeader, "unexpected header");

    }
}


