import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path dir = Paths.get("C:\\User\\Desktop");
        try (Stream<Path> stream = Files.list(dir)) {
            stream.forEach(System.out::println);
            String content = Files.list(dir).toString();
            Files.write(dir, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("File created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
