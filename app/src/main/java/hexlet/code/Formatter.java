package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.List;

public class Formatter {

    public static String run(Map<String, Object> map1,
                             Map<String, Object> map2,
                             Map<String, Object> resultOfDiffer,
                             String format) throws JsonProcessingException {
        if (format.equals("stylish")) {
            return stylish(map1, map2, resultOfDiffer);
        } else if (format.equals("plain")) {
            return plain(map1, map2, resultOfDiffer);
        } else if (format.equals("json")) {
            return json(map1, map2, resultOfDiffer);
        }
        return "Don't know this format";
    }

    public static String stylish(Map<String, Object> map1,
                                 Map<String, Object> map2,
                                 Map<String, Object> resultOfDiffer) {
        String resultString = "{";
        for (Map.Entry<String, Object> entry : resultOfDiffer.entrySet()) {
            switch (entry.getValue().toString()) {
                case "updated":
                    resultString += "\n" + "  - " + entry.getKey() + ": " + map1.get(entry.getKey());
                    resultString += "\n" + "  + " + entry.getKey() + ": " + map2.get(entry.getKey());
                    break;
                case "added":
                    resultString += "\n" + "  + " + entry.getKey() + ": " + map2.get(entry.getKey());
                    break;
                case "removed":
                    resultString += "\n" + "  - " + entry.getKey() + ": " + map1.get(entry.getKey());
                    break;
                case "unchanged":
                    resultString += "\n" + "    " + entry.getKey() + ": " + map1.get(entry.getKey());
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

            addQuotesToString(map1, entry);
            addQuotesToString(map2, entry);

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
        StringUtils.removeEnd(resultString, "\n");
        return resultString.trim();
    }
    public static String json(Map<String, Object> map1,
                                 Map<String, Object> map2,
                                 Map<String, Object> resultOfDiffer) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(resultOfDiffer);
        return json;
    }

    public static void addQuotesToString(Map<String, Object> map,
                                         Map.Entry<String, Object> entry) {
        if (map.get(entry.getKey()) instanceof String) {
            map.put(entry.getKey(), "'" + map.get(entry.getKey()) + "'");
        }
    }

    public static void checkComplexValue(Map<String, Object> map, Map.Entry<String, Object> entry) {
        if (map.get(entry.getKey()) instanceof Map || map.get(entry.getKey()) instanceof List) {
            map.put(entry.getKey(), "[complex value]");
        }
    }
}
