package adventofcode.quizcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Quiz2Test {

    @Test
    void solveIt_givenExampleInput_part1() {
        Quiz2 quiz = new Quiz2();
        long result = quiz.solvePart1("input2.txt");
        assertEquals(2, result);
    }
    @Test
    void solveIt_givenExampleInput_part2() {
        Quiz2 quiz = new Quiz2();
        long result = quiz.solvePart2("input2.txt");
        assertEquals(4, result);
    }

}