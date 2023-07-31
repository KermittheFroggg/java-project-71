package hexlet.code;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    public void testDiffer() throws Exception {

        File file = new File("./src/test/resources/result.json");
        String result = Files.readString(file.toPath());

        String fileFirst = "./src/test/resources/first.json";
        String fileSecond = "./src/test/resources/first.json";
        System.out.println(Differ.generate(fileFirst, fileSecond));
        Assert.assertEquals(result, Differ.generate(fileFirst, fileSecond));
        assertThat(result).isEqualTo(Differ.generate(fileFirst, fileSecond));
    }
}
