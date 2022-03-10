
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> links = new ArrayList<String>();
        final String regex = "(?<!!)(?<!`)\\[(?>[[a-zA-Z0-9 ]&&[^\\n]])+\\]\\((\\S+)\\)";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(markdown);

        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                links.add(matcher.group(i));
            }
        }

        return links;
    }


    public static String getContentFromFile(String filePath) throws Exception {
        Path fileName = Path.of(filePath);
        String contents = Files.readString(fileName);
        return contents;
    }

    public static void main(String[] args) throws IOException {
        try {
            String contents = getContentFromFile("snippet1.md");
            ArrayList<String> links = getLinks(contents);
            System.out.println(links);
        } catch (Exception ex) {

        }

    }
}