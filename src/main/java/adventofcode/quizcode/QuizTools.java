package adventofcode.quizcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class QuizTools {

    private List<String> lines;

    //set only from constructor, to avoid any issues later on.
    public List<String> getLines() {
        return lines;
    }

    //constructor, assume folder structure src/adventofcode/quizcode/res/
    public QuizTools(String filename) {
        //transforms file name to path
        Path path = Paths.get("src/main/java/adventofcode/quizcode/res/" + filename);
        //call fileToStringList
        fileToStringList(path);

    }

    private void fileToStringList(Path path) {
        try {
            this.lines = Files.readAllLines(path);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
