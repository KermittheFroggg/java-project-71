package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String file) throws Exception {
        String extension = "";

        int i = file.lastIndexOf('.');
        if (i > 0) {
            extension = file.substring(i + 1);
        }
        if (extension.equals("yml")) {
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Map<String, Object> resultYml = yamlReader.readValue(Path.of(file).toAbsolutePath().toFile(), Map.class);
            return resultYml;
        } else if (extension.equals("json")) {
            ObjectMapper objectMapper = new ObjectMapper();

            Map<String, Object> resultJson = objectMapper.readValue(Path.of(file).toAbsolutePath().toFile(), Map.class);
            return resultJson;
        }
        return null;
    }
}
