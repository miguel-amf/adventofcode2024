package adventofcode.quizcode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public interface Quiz {
        long solvePart1(String filename);
        long solvePart2(String filename);

        default List<String> getLines(String filename) {
                InputStream inputStream = getClass().getResourceAsStream("/input/" + filename);
                if (inputStream == null) {
                        throw new IllegalArgumentException("File Not Found: " + filename);
                }
                try {
                        return new BufferedReader(new InputStreamReader(inputStream))
                                .lines()
                                .collect(Collectors.toList());
                } catch (Exception e) {
                        throw new RuntimeException("Error reading file: " + filename, e);
                }
        }
}
