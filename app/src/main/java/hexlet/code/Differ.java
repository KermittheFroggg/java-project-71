package hexlet.code;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Differ {
    public static String generate(String file1, String file2, String format) throws Exception {

        Map<String, Object> map1 = Parser.parser(file1);
        Map<String, Object> map2 = Parser.parser(file2);

        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        Map<String, Object> result = new LinkedHashMap<>();
        for (String key : keys) {
            if (map1.containsKey(key)) {
                if (map2.containsKey(key)) {
                    if (Objects.equals(map1.get(key), map2.get(key))) {
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

        if (format.equals("stylish")) {
            return Formatter.stylish(result);
        }
        return "Не знаю такого формата";
    }

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
                    if (Objects.equals(map1.get(key), map2.get(key))) {
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

        return Formatter.stylish(result);
    }
}
