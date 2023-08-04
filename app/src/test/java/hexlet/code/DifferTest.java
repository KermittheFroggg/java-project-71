package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    public void testDiffer() throws Exception {

        File fileJson = new File("./src/test/resources/json/resultJson.json");
        String resultJson = Files.readString(fileJson.toPath());
        String firstJson = "./src/test/resources/json/firstJson.json";
        String secondJson = "./src/test/resources/json/secondJson.json";
        assertThat(resultJson).isEqualTo(Differ.generate(firstJson, secondJson, "stylish"));

        File fileYaml = new File("./src/test/resources/yaml/resultYaml.yml");
        String resultYaml = Files.readString(fileYaml.toPath());
        String firstYaml = "./src/test/resources/yaml/firstYaml.yml";
        String secondYaml = "./src/test/resources/yaml/secondYaml.yml";
        assertThat(resultYaml).isEqualTo(Differ.generate(firstYaml, secondYaml));

        File fileJsonNested = new File("./src/test/resources/jsonNested/resultJsonNested.json");
        String resultJsonNested = Files.readString(fileJsonNested.toPath());
        String firstJsonNested = "./src/test/resources/jsonNested/firstJsonNested.json";
        String secondJsonNested = "./src/test/resources/jsonNested/secondJsonNested.json";
        assertThat(resultJsonNested).isEqualTo(Differ.generate(firstJsonNested, secondJsonNested));

        File fileYamlNested = new File("./src/test/resources/yamlNested/resultYamlNested.yml");
        String resultYamlNested = Files.readString(fileYamlNested.toPath());
        String firstYamlNested = "./src/test/resources/yamlNested/firstYamlNested.yml";
        String secondYamlNested = "./src/test/resources/yamlNested/secondYamlNested.yml";
        assertThat(resultYamlNested).isEqualTo(Differ.generate(firstYamlNested, secondYamlNested));

        File fileJsonNestedPlain = new File("./src/test/resources/jsonNestedPlain/resultJsonNestedPlain.json");
        String resultJsonNestedPlain = Files.readString(fileJsonNestedPlain.toPath());
        String firstJsonNestedPlain = "./src/test/resources/jsonNestedPlain/firstJsonNestedPlain.json";
        String secondJsonNestedPlain = "./src/test/resources/jsonNestedPlain/secondJsonNestedPlain.json";
        assertThat(resultJsonNestedPlain).isEqualTo(Differ.generate(firstJsonNestedPlain,
                                                                    secondJsonNestedPlain,
                                                                "plain"));

        File fileJsonFile = new File("./src/test/resources/jsonFile/resultJson.json");
        String resultJsonFile = Files.readString(fileJsonFile.toPath());
        String firstJsonFile = "./src/test/resources/jsonFile/firstJson.json";
        String secondJsonFile = "./src/test/resources/jsonFile/secondJson.json";
        assertThat(resultJsonFile).isEqualTo(Differ.generate(firstJsonFile,
                secondJsonFile,
                "json"));

    }
}
