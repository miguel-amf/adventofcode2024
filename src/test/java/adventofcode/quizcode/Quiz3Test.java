package adventofcode.quizcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Quiz3Test {

    @Test
    void solveIt_givenExampleInput_part1() {
        Quiz3 quiz = new Quiz3();
        long result = quiz.solvePart1("input3.txt");
        assertEquals(161, result);
    }

    @Test
    void solveIt_givenExampleInput_part2() {
        Quiz3 quiz = new Quiz3();
        long result = quiz.solvePart2("input3.txt");
        assertEquals(48, result);
    }
}