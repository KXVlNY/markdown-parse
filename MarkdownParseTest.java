import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1); // Test addition methods and make sure it returns 2
    }
    public void getLinks() {
        Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);

    }
}