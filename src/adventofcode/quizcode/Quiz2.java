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
        int lineCnt = 0;

        //each line represents a report. iterating over each.
        for(String report : lines) {
            //System.out.println(report);
            //lineCnt++;
            //if(lineCnt >= 10) break;
            int unsafe = 0;
            //break the line into strings for each number
            String[] values = report.split("\\s+");
            //set a flag for ascending or descending (-1 decreasing, 1 increasing)
            int direction;
            //check first two numbers to check trend
            if(parseInt(values[0]) < parseInt(values[1])) {
                //System.out.println("asc");
                direction = 1;
            } else {
                //System.out.println("desc");
                direction = -1;
            }

            for(int i = 0; i < values.length - 1; i++) {
                //convert the number and next one to be compared
                int current = parseInt(values[i]);
                int next = parseInt(values[i+1]);
                //checks for the 4 unsafe scenarios: breaking
                if ((direction == 1 && current >= next)         ||  // Ascending violation (or equals)
                    (direction == -1 && current <= next)        ||  // Descending violation (or equals)
                    (Math.abs(current - next) > 3))               // Difference too large
                {
                    //System.out.println("UNSAFE");
                    unsafe = 1;
                    break;
                }
            }
            //if none unsafe checks flagged, it should remain 0
            if(unsafe == 0) {
                //System.out.println("SAFE");
                safeCount++;
            }
        }

        return safeCount;
    }
}
