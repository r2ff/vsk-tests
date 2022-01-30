package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectToJSON {

    public static String objectToJSON(Object o) throws IOException {
        return new ObjectMapper().writeValueAsString(o);
    }
}
