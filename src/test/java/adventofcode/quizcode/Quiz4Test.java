package adventofcode.quizcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Quiz4Test {

    @Test
    void solvePart1() {
        Quiz4 quiz = new Quiz4();
        long result = quiz.solvePart1("input4.txt");
        assertEquals(7, result);
    }

    @Test
    void solvePart2() {
        Quiz4 quiz = new Quiz4();
        long result = quiz.solvePart2("input4.txt");
        assertEquals(0, result);
    }
}