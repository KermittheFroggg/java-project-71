package hexlet.code;

import java.util.Map;
import java.util.List;

public class Formatter {
    public static String stylish(Map<String, Object> map1,
                                 Map<String, Object> map2,
                                 Map<String, Object> resultOfDiffer) {
        String resultString = "{";
        for (Map.Entry<String, Object> entry : resultOfDiffer.entrySet()) {
            if (entry.getValue().equals("same")) {
                resultString = resultString + "\n" + "    " + entry.getKey() + ": " + map1.get(entry.getKey());
            } else if (entry.getValue().equals("updated")) {
                resultString = resultString + "\n" + "  - " + entry.getKey() + ": " + map1.get(entry.getKey());
                resultString = resultString + "\n" + "  + " + entry.getKey() + ": " + map2.get(entry.getKey());
            } else if (entry.getValue().equals("removed")) {
                resultString = resultString + "\n" + "  - " + entry.getKey() + ": " + map1.get(entry.getKey());
            } else if (entry.getValue().equals("added")) {
                resultString = resultString + "\n" + "  + " + entry.getKey() + ": " + map2.get(entry.getKey());
            }
        }
        return resultString + "\n" + "}";
    }

    public static String plain(Map<String, Object> map1,
                               Map<String, Object> map2,
                               Map<String, Object> resultOfDiffer) {
        String resultString = "";
        for (Map.Entry<String, Object> entry : resultOfDiffer.entrySet()) {
            if (map1.get(entry.getKey()) instanceof String) {
                map1.put(entry.getKey(), "'" + map1.get(entry.getKey()) + "'");
            }
            if (map2.get(entry.getKey()) instanceof String) {
                map2.put(entry.getKey(), "'" + map2.get(entry.getKey()) + "'");
            }
            if (entry.getValue().equals("updated")) {
                if (map1.get(entry.getKey()) instanceof Map || map1.get(entry.getKey()) instanceof List) {
                    map1.put(entry.getKey(), "[complex value]");
                }
                if (map2.get(entry.getKey()) instanceof Map || map2.get(entry.getKey()) instanceof List) {
                    map2.put(entry.getKey(), "[complex value]");
                }
                resultString = resultString + "Property '" + entry.getKey() + "' was updated. From "
                        + map1.get(entry.getKey()) + " to " + map2.get(entry.getKey()) + "\n";
            } else if (entry.getValue().equals("added")) {
                if (map2.get(entry.getKey()) instanceof Map || map2.get(entry.getKey()) instanceof List) {
                    map2.put(entry.getKey(), "[complex value]");
                }
                resultString = resultString + "Property '" + entry.getKey() + "' was added with value: "
                        + map2.get(entry.getKey()) + "\n";
            } else if (entry.getValue().equals("removed")) {
                resultString = resultString + "Property '" + entry.getKey() + "' was removed" + "\n";
            }
        }
        return resultString.trim();
    }
}
