package adventofcode.quizcode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Quiz2 {

    public long solveItPart1() {

        //declaring and initializing variables
        List<String> lines;
        QuizTools quizTools = new QuizTools("input2.txt");
        lines = quizTools.getLines();
        long safeCount = 0;

        //each line represents a report. iterating over each.
        for(String report : lines) {
            ArrayList<Integer> intReport = stringToIntArray(report);
            ArrayList<Integer> currentAttempt = stringToIntArray(report);

            boolean result = checkLine(currentAttempt);
            if(result) {
                safeCount++;
            }
        }

        return safeCount;
    }

    public long solveItPart2() {

        //declaring and initializing variables
        List<String> lines;
        QuizTools quizTools = new QuizTools("input2.txt");
        lines = quizTools.getLines();
        long safeCount = 0;

        //each line represents a report. iterating over each.
        for(String report : lines) {
            ArrayList<Integer> intReport = stringToIntArray(report);

            //checkline should return true if report is safe
            if(checkLine(intReport)) {
                safeCount++;
            } else { //if not safe at first, try to remove elements
                for(int i = 0; i < intReport.size();i++) {
                    ArrayList<Integer> currentAttempt = new ArrayList<>(intReport);
                    currentAttempt.remove(i);
                    if(checkLine(currentAttempt)) {
                        safeCount++;
                        break;
                    }
                }
            }
        }

        return safeCount;
    }

    private boolean checkLine(ArrayList<Integer> line) {
        //in case of a report of 1 element, it should be safe as it fulfill all conditions
        if(line.size() < 2) return true;
        //set a flag for ascending or descending (-1 decreasing, 1 increasing)
        int direction;
        //check first two numbers to check trend
        if(line.get(0) < line.get(1)) {
            direction = 1;
        } else {
            direction = -1;
        }

        for(int i = 0; i < line.size() - 1; i++) {
            //convert the number and next one to be compared
            int current = line.get(i);
            int next = line.get(i+1);
            //checks for the 4 unsafe scenarios: breaking
            if ((direction == 1 && current >= next)         ||  // Ascending violation (or equals)
                    (direction == -1 && current <= next)        ||  // Descending violation (or equals)
                    (Math.abs(current - next) > 3))               // Difference too large
            {
                //unsafe
                return false;
            }
        }
        //safe
        return true;
    }

    private ArrayList<Integer> stringToIntArray(String input) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        String[] values = input.split("\\s+");
        for (String value : values) {
            //convert string to int
            output.add(parseInt(value));

        }
        return output;
    }
}
