package adventofcode.quizcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quiz1Test {

    @Test
    void solveIt_givenExampleInputPart1() {
        Quiz1 quiz = new Quiz1();
        long result = quiz.solvePart1("input1.txt");
        assertEquals(11, result);
    }
    @Test
    void solveIt_givenExampleInputPart2() {
        Quiz1 quiz = new Quiz1();
        long result = quiz.solvePart2("input1.txt");
        assertEquals(-1, result);
    }

}