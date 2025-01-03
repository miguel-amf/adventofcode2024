package adventofcode.quizcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Quiz4Test {

    @Test
    void solvePart1() {
        Quiz4 quiz = new Quiz4();
        long result = quiz.solvePart1("input3.txt");
        assertEquals(5, result);
    }

    @Test
    void solvePart2() {
        Quiz4 quiz = new Quiz4();
        long result = quiz.solvePart1("input3.txt");
        assertEquals(0, result);
    }
}