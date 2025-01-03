package adventofcode.quizcode;

import java.util.ArrayList;
import java.util.List;

public class Quiz1 implements Quiz {

        @Override
        public long solvePart1(String filename) {

        //declaring variables
        List<String> lines;
        List<Integer> firstList = new ArrayList<Integer>();
        List<Integer> secondList = new ArrayList<Integer>();
        long result = 0;

        //get the lines as string
        lines = getLines(filename);
        //populate the arrays with respective numbers
        for (String line : lines) {
            //extract numbers from each line, they seem to be separated by some spaces, don't know how many
            String[] numbers = line.split("\\s+");

            firstList.add(Integer.parseInt(numbers[0]));
            secondList.add(Integer.parseInt(numbers[1]));
            //System.out.println(firstList.getLast() + ", " + secondList.getLast());
        }
        //sort each, ascending (null defaults to ascending)
        firstList.sort(null);
        secondList.sort(null);

        //check if same size
        if (firstList.size() != secondList.size()) {
            throw new IllegalArgumentException("Lists must be same size");
        }
        for (int i = 0;i<firstList.size();i++) {
            //using absolute, as the bigger number might not always be in the same column
            result += Math.abs(firstList.get(i) - secondList.get(i));
        }
        return result;
    }

    @Override
    public long solvePart2(String input) {
        //not implemented
        return -1;
    }


}
