package hexlet.code;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(File file1, File file2) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> map1 = objectMapper.readValue(file1, Map.class);
        Map<String, Object> map2 = objectMapper.readValue(file2, Map.class);

        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        Map<String, Object> result = new LinkedHashMap<>();
        for (String key : keys) {
            if (map1.containsKey(key)) {
                if (map2.containsKey(key)) {
                    if (map1.get(key).equals(map2.get(key))) {
                        result.put(key, map1.get(key));
                    } else {
                        result.put("- " + key, map1.get(key));
                        result.put("+ " + key, map2.get(key));
                    }
                } else {
                    result.put("- " + key, map1.get(key));
                }
            } else {
                result.put("+ " + key, map2.get(key));
            }
        }
        String resultString = "{";
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            if (entry.getKey().startsWith("+") || entry.getKey().startsWith("-")) {
                resultString = resultString + "\n" + "  " + entry.getKey() + ": " + entry.getValue();
            } else {
                resultString = resultString + "\n" + "    " + entry.getKey() + ": " + entry.getValue();
            }
        }
        System.out.println(resultString + "\n" + "}");
        return resultString + "\n" + "}";
    }
}
