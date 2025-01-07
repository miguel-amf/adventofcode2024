package adventofcode.quizcode;

import java.util.List;

public class Quiz4 implements Quiz{

    @Override
    public long solvePart1(String filename) {
        //declaring and initializing variables
        List<String> lines;
        lines = getLines(filename);
        long xmasCount = 0;

        //from the line, go over each character and check if it is X.
        //if so, check for any nearby M, and so on, until it finds XMAS
        //the line being tested is represented by i
        //the character being tested (aka column) is represented by j
        for(int i = 0; i< lines.size(); i++) {
            for(int j = 0; j<lines.get(i).length();j++) {
                //System.out.println("TESTING I J:" + i + j);
                if(lines.get(i).charAt(j) == 'X') {
                    //System.out.println("GOT INSIDE IF");
                    xmasCount = xmasCount + checkHorizontal(lines, i, j);
                    xmasCount = xmasCount + checkVertical(lines, i, j);
                }
            }
        }
        return xmasCount;
    }

    @Override
    public long solvePart2(String filename) {
        //declaring and initializing variables
        List<String> lines;
        lines = getLines(filename);
        return 0;
    }

    private int checkHorizontal(List<String> lines, int i, int j) {
        int count = 0;
        //this could be achieved by going for sub
        //System.out.println("Start testing for: " + lines.get(i).substring(j) +" length: " + lines.get(i).length() + " j value: " + j);
        //first, check if there is enough space for forward xmas, given j position
        if(j<(lines.get(i).length()-4)) {
            //System.out.println("FORWARD: i "+ i + " j " + j + "String to be checked: " + lines.get(i).substring(j,j+4));
            if(lines.get(i).substring(j,j+4).equals(("XMAS")))  {
                count++;
            }
        }
        //check if there is enough space for backwards xmas (samx), given j position
        //System.out.println("BACK TEST:");
        if(j>=4) {
            //System.out.println("BACKWARDS: i "+ i + " j " + j + "String to be checked: " + lines.get(i).substring(j-4,j));
            if(lines.get(i).substring(j-4,j).equals(("SAMX"))) {
                count++;
            }
        }
        if(count!=0) {
            System.out.println("Returning: " + count);
        }
        return count;
    }

    private int checkVertical(List<String> lines, int i, int j) {
        int count = 0;
        String xmasString = "XMAS";
        //check if there is XMAS upwards
        //we lock the j (column) and go upwards on the i (line).
        if(i>=4) {
            //on the for loops, it will try to falsify the statement of not existing XMAS pattern
            boolean found = true;
            // variable l is to keep track of the letter to be checked
            for(int offset = 0; offset < 4; offset++) {
                if(lines.get(i-offset).charAt(j) != xmasString.charAt(offset)) {
                    found = false;
                    break;
                }
            }
            if(found) {
                count++;
            }
        }

        //check if there is a XMAS downwards
        if(i<lines.size()-4) {
            //on the for loops, it will try to falsify the statement of not existing XMAS pattern
            boolean found = true;
            // variable l is to keep track of the letter to be checked
            for(int offset = 0; offset < 4; offset++) {
                if(lines.get(i+offset).charAt(j) != xmasString.charAt(offset)) {
                    found = false;
                    break;
                }
            }
            if(found) {
                count++;
            }
        }

        return count;
    }


}