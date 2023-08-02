package hexlet.code;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    public void testDiffer() throws Exception {

        File file = new File("./src/test/resources/resultJson.json");
        String result = Files.readString(file.toPath());

        String firstJson = "./src/test/resources/firstJson.json";
        String secondJson = "./src/test/resources/secondJson.json";

        String firstYaml = "./src/test/resources/firstYaml.yml";
        String secondYaml = "./src/test/resources/secondYaml.yml";

        Assert.assertEquals(result, Differ.generate(firstJson, secondJson));
        assertThat(result).isEqualTo(Differ.generate(firstJson, secondJson));
        assertThat(result).isEqualTo(Differ.generate(firstYaml, secondYaml));

    }
}
