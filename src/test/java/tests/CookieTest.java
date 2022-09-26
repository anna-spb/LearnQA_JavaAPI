package tests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CookieTest {
    @Test
    public void testCookie() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();


        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);
        String cookie = response.cookie("HomeWork");
        System.out.println(cookie);

        assertEquals("hw_value", cookie, "unexpected cookie");

    }
}
