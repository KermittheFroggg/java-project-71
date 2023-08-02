package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String file1, String file2) throws Exception {

        Map<String, Object> map1 = Parser.parser(file1);
        Map<String, Object> map2 = Parser.parser(file2);

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
        return resultString + "\n" + "}";
    }
}
