import java.io.IOException;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;

public class MarkdownParseTest {

    public static String getContentFromFile(String filePath) throws Exception {
        Path fileName = Path.of(filePath);
        String contents = Files.readString(fileName);
        return contents;
    }

    @Test
    public void testGetLinks1() throws IOException {
        try {
            String contents = getContentFromFile("snippet1.md");
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            List<String> linksTest =
                    List.of("`google.com","google.com","ucsd.edu");

            assertEquals(linksTest, links);
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetLinks2() throws IOException {
        try {
            String contents = getContentFromFile("snippet2.md");
            ArrayList<String> links = MarkdownParse.getLinks(contents);

            List<String> linksTest =
                    List.of("a.com","a.com(())","example.com");

            assertEquals(linksTest, links);
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetLinks3() throws IOException {
        try {
            String contents = getContentFromFile("snippet3.md");
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            List<String> linksTest =
                    List.of("https://ucsd-cse15l-w22.github.io/");

            assertEquals(linksTest, links);
        } catch (Exception e) {

        }
    }
}