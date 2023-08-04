package hexlet.code;

import java.util.Map;
import java.util.List;

public class Formatter {
    public static String stylish(Map<String, Object> map1,
                                 Map<String, Object> map2,
                                 Map<String, Object> resultOfDiffer) {
        String resultString = "{";
        for (Map.Entry<String, Object> entry : resultOfDiffer.entrySet()) {
            switch (entry.getValue().toString()) {
                case "updated":
                    resultString = resultString + "\n" + "  - " + entry.getKey() + ": " + map1.get(entry.getKey());
                    resultString = resultString + "\n" + "  + " + entry.getKey() + ": " + map2.get(entry.getKey());
                    break;
                case "added":
                    resultString = resultString + "\n" + "  + " + entry.getKey() + ": " + map2.get(entry.getKey());
                    break;
                case "removed":
                    resultString = resultString + "\n" + "  - " + entry.getKey() + ": " + map1.get(entry.getKey());
                    break;
                case "same":
                    resultString = resultString + "\n" + "    " + entry.getKey() + ": " + map1.get(entry.getKey());
                    break;
                default:
                    continue;
            }
        }
        return resultString + "\n" + "}";
    }

    public static String plain(Map<String, Object> map1,
                               Map<String, Object> map2,
                               Map<String, Object> resultOfDiffer) {
        String resultString = "";
        for (Map.Entry<String, Object> entry : resultOfDiffer.entrySet()) {
            addQuotesToString(map1, map2, entry);
            switch (entry.getValue().toString()) {
                case "updated":
                    checkComplexValue(map1, entry);
                    checkComplexValue(map2, entry);
                    resultString = resultString + "Property '" + entry.getKey() + "' was updated. From "
                            + map1.get(entry.getKey()) + " to " + map2.get(entry.getKey()) + "\n";
                    break;
                case "added":
                    checkComplexValue(map2, entry);
                    resultString = resultString + "Property '" + entry.getKey() + "' was added with value: "
                            + map2.get(entry.getKey()) + "\n";
                    break;
                case "removed":
                    resultString = resultString + "Property '" + entry.getKey() + "' was removed" + "\n";
                    break;
                default:
                    continue;
            }
        }
        return resultString.trim();
    }

    public static void addQuotesToString(Map<String, Object> map1,
                                         Map<String, Object> map2,
                                         Map.Entry<String, Object> entry) {
        if (map1.get(entry.getKey()) instanceof String) {
            map1.put(entry.getKey(), "'" + map1.get(entry.getKey()) + "'");
        }
        if (map2.get(entry.getKey()) instanceof String) {
            map2.put(entry.getKey(), "'" + map2.get(entry.getKey()) + "'");
        }
    }

    public static void checkComplexValue(Map<String, Object> map, Map.Entry<String, Object> entry) {
        if (map.get(entry.getKey()) instanceof Map || map.get(entry.getKey()) instanceof List) {
            map.put(entry.getKey(), "[complex value]");
        }
    }
}
