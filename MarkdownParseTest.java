import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> linkList = List.of("https://something.com", "some-page.html");
        assertEquals(linkList, links);
    }
    @Test
    public void getLinks2() throws IOException{
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> linkList = List.of();
        assertEquals(linkList, links);
    }
    @Test
    public void getLinks3() throws IOException{
        Path fileName = Path.of("test-file2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> linkList = List.of("https://som(eth");
        assertEquals(linkList, links);
    }
    @Test
    public void getLinks4() throws IOException{
        Path fileName = Path.of("test-file4.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> linkList = List.of();
        assertEquals(linkList, links);
    }

    @Test
    public void snippet1() throws IOException{
	    String contents = Files.readString(Path.of("snippet1.md"));
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> linkList = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(linkList, links);
    }

    @Test
    public void snippet2() throws IOException{
	    String contents = Files.readString(Path.of("snippet2.md"));
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> linkList = List.of("a.com", "a.com((", "example.com");
        assertEquals(linkList, links);
    }

    @Test
    public void snippet3() throws IOException{
	    String contents = Files.readString(Path.of("snippet3.md"));
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> linkList = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(linkList, links);
    }
}

/**
 * To compile the tests:
 * javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
 * java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
 */