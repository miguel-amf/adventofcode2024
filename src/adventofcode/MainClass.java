package adventofcode;

import adventofcode.quizcode.Quiz1;
import adventofcode.quizcode.Quiz2;

public class MainClass {
    public static void main(String[] args) {
        Quiz1 q1 = new Quiz1();
        Quiz2 q2 = new Quiz2();
        System.out.println("Result of quiz 1: " + q1.solveIt());
        System.out.println("Result of quiz 1: " + q2.solveIt());
    }
}
