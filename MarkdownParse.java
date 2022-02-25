// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            // Ensures that if there is a [, it is followed by ] and if there is a (, it is followed by )
            if (markdown.indexOf("(") == -1 && markdown.indexOf(")") != -1 ||
                markdown.indexOf(")") == -1 && markdown.indexOf("(") != -1 ||
                markdown.indexOf("[") == -1 && markdown.indexOf("]") != -1 ||
                markdown.indexOf("]") == -1 && markdown.indexOf("[") != -1) {
                    break;
                }
            else {
                if (markdown.indexOf("(") < markdown.indexOf("[") && markdown.indexOf("(") != -1) {
                    int openParen = markdown.indexOf("(", currentIndex);
                    int closeParen = markdown.indexOf(")", openParen);
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    int nextOpenBracket = markdown.indexOf("[", closeParen);
                    int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
                    currentIndex = nextCloseBracket + 1;
                }
                else {
                    int nextOpenBracket = markdown.indexOf("[", currentIndex);
                    int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
                    if (markdown.indexOf("(") != -1 || markdown.indexOf(")") != -1) {
                        int openParen = markdown.indexOf("(", nextCloseBracket);
                        int closeParen = markdown.indexOf(")", openParen);
                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                        currentIndex = closeParen + 1;
                    }
                    else {
                        currentIndex = nextCloseBracket + 1;
                    }
                }
            }
            // Checks if ( comes before 
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}