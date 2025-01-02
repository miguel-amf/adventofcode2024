package adventofcode;

import adventofcode.quizcode.Quiz;

public class MainClass {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            try {
                Quiz quiz = createQuiz(i);
                String input = "input" + i + ".txt";
                System.out.printf("Result of quiz %d(Part1): %s%n", i, quiz.solvePart1(input));
                System.out.printf("Result of quiz %d(Part2): %s%n", i, quiz.solvePart2(input));
            } catch(Exception e) {
                System.out.printf(e.getMessage());
            }
        }
    }

    //to avoid a long list 1 to 25, instantiate quizzes objects using the file naming convention
    private static Quiz createQuiz(int number) {
        try {
            return (Quiz) Class.forName("adventofcode.quizcode.Quiz" + number).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Quiz" + number, e);
        }
    }
}
