package hexlet.code;
import picocli.CommandLine.Option;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
    }
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    Path file;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    Path file2;
    @Override
    public Object call() {
        try {
            System.out.println(Differ.generate(file, file2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ;
        return null;
    }
}