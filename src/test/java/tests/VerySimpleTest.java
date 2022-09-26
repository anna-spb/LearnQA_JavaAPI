package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerySimpleTest {

    @Test
    public void lengthPar() {
        String test = "move your mind! ";



        assertTrue(test.length() > 15, "Error, length is less than expected");

    }
}
