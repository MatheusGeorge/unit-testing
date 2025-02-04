package br.com.estudos.unit_testing.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssertStrictTrueExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
        // strict = true validates the structure of the json, has to match all the structure
    }

    @Test
    public void jsonAssertStrictFalseExactMatch() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
        // strict = false not validates the structure of the json, only check if the expectedResponse structure contains
        // in the actualResponse
    }

    @Test
    public void jsonAssertWithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id: 1, name: Ball, price: 10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
        // strict = false not validates the structure of the json, only check if the expectedResponse structure contains
        // in the actualResponse
    }
}
