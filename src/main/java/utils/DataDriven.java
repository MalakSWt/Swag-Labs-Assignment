package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class DataDriven {
    public static String[] jsonReader(String userType) {
        JSONParser parser = new JSONParser();
        String[] data = new String[2];

        try {
            FileReader reader = new FileReader("src/testData/testData.json");
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject user = (JSONObject) jsonObject.get(userType);

            data[0] = (String) user.get("username");
            data[1] = (String) user.get("password");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
