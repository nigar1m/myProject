package data;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private static final Map<String, String> testDataMap = new HashMap<>();

    static {
        testDataMap.put("username", "testUser");
        testDataMap.put("password", "testPassword123");
        testDataMap.put("baseUrl", "https://reqres.in");
        testDataMap.put("getApiEndpoint", "/api/users?page=2");
        testDataMap.put("postApiEndpoint", "/api/users");
        testDataMap.put("putApiEndpoint", "/api/users/2");
        testDataMap.put("deleteApiEndpoint", "/api/users/2");
        testDataMap.put("patchApiEndpoint", "/api/users/2");

    }

    public static String getTestData(String key) {
        return testDataMap.getOrDefault(key, "Key not found");
    }
}
