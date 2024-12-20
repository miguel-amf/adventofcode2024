package adventofcode.quizcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class QuizTools {

    private List<String> lines;
    private Path filePath;

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public List<String> getLines() {
        return lines;
    }



    //assume folder structure
    public QuizTools(String filename) {
        this.filePath = Paths.get("src/adventofcode/quizcode/res/" + filename);
        fileToStringList();

    }

    private void fileToStringList() {
        try {
            this.lines = Files.readAllLines(this.filePath);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
