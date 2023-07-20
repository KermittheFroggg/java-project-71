package hexlet.code;
import picocli.CommandLine.Option;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
    }
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    File file;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    File file2;
    @Override
    public void run() {
        System.out.println("Hello world");
        ;
    }
}