package hexlet.code;

import java.util.Map;

public class Formatter {
    public static String stylish(Map<String, Object> resultOfDiffer) {
        String resultString = "{";
        for (Map.Entry<String, Object> entry : resultOfDiffer.entrySet()) {
            if (entry.getKey().startsWith("+") || entry.getKey().startsWith("-")) {
                resultString = resultString + "\n" + "  " + entry.getKey() + ": " + entry.getValue();
            } else {
                resultString = resultString + "\n" + "    " + entry.getKey() + ": " + entry.getValue();
            }
        }
        return resultString + "\n" + "}";
    }
}
