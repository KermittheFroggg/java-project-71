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

        File fileJsonFilePlain = new File("./src/test/resources/hexletTests/result_plain.txt");
        String resultJsonFilePlain = Files.readString(fileJsonFilePlain.toPath());
        String firstJsonFilePlain = "./src/test/resources/hexletTests/file1.json";
        String secondJsonFilePlain = "./src/test/resources/hexletTests/file2.json";
        assertThat(Differ.generate(firstJsonFilePlain,
                secondJsonFilePlain,
                "plain")).isEqualTo(resultJsonFilePlain);

        File fileYamlFilePlain = new File("./src/test/resources/hexletTests/result_plain.txt");
        String resultYamlFilePlain = Files.readString(fileYamlFilePlain.toPath());
        String firstYamlFilePlain = "./src/test/resources/hexletTests/file1.yml";
        String secondYamlFilePlain = "./src/test/resources/hexletTests/file2.yml";
        assertThat(Differ.generate(firstYamlFilePlain,
                secondYamlFilePlain,
                "plain")).isEqualTo(resultYamlFilePlain);

        File fileJsonFileStylish = new File("./src/test/resources/hexletTests/result_stylish.txt");
        String resultJsonFileStylish = Files.readString(fileJsonFileStylish.toPath());
        String firstJsonFileStylish = "./src/test/resources/hexletTests/file1.json";
        String secondJsonFileStylish = "./src/test/resources/hexletTests/file2.json";
        assertThat(Differ.generate(firstJsonFileStylish,
                secondJsonFileStylish,
                "stylish")).isEqualTo(resultJsonFileStylish);

        File fileYamlFileStylish = new File("./src/test/resources/hexletTests/result_stylish.txt");
        String resultYamlFileStylish = Files.readString(fileYamlFileStylish.toPath());
        String firstYamlFileStylish = "./src/test/resources/hexletTests/file1.yml";
        String secondYamlFileStylish = "./src/test/resources/hexletTests/file2.yml";
        assertThat(Differ.generate(firstYamlFileStylish,
                secondYamlFileStylish,
                "stylish")).isEqualTo(resultYamlFileStylish);
    }
}
