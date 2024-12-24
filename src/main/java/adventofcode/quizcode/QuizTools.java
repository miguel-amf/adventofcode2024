package adventofcode.quizcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class QuizTools {

    private List<String> lines;

    //set only from constructor, to avoid any issues later on.
    public List<String> getLines() {
        return lines;
    }

    //constructor, assume folder structure src/adventofcode/quizcode/res/
    public QuizTools(String filename) {
        InputStream inputStream = getClass().getResourceAsStream("/input/" + filename);
        if (inputStream == null) {
            throw new IllegalArgumentException("File Not Found: " + filename);
        }
        try {
            lines = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.toList());
            // Use your lines here
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + filename, e);
        }
    }

    private void fileToStringList(Path path) {
        try {
            this.lines = Files.readAllLines(path);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
