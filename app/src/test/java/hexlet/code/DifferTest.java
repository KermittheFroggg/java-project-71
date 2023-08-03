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
        File fileYaml = new File("./src/test/resources/yaml/resultYaml.yml");
        String resultYaml = Files.readString(fileYaml.toPath());

        String firstJson = "./src/test/resources/json/firstJson.json";
        String secondJson = "./src/test/resources/json/secondJson.json";

        String firstYaml = "./src/test/resources/yaml/firstYaml.yml";
        String secondYaml = "./src/test/resources/yaml/secondYaml.yml";

        assertThat(resultJson).isEqualTo(Differ.generate(firstJson, secondJson));
        assertThat(resultYaml).isEqualTo(Differ.generate(firstYaml, secondYaml));

    }
}
