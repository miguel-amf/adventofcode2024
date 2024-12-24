package adventofcode.quizcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quiz1Test {

    @Test
    void solveIt_givenExampleInput() {
        Quiz1 quiz = new Quiz1();
        long result = quiz.solveIt("input1.txt");
        assertEquals(11, result);
    }

}