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
                    if(checkHorizontal(lines, i, j)) {
                        System.out.println("FOUND XMAS OR SAMX HORIZONTALLY! i: " + i + " j: " + j);
                        xmasCount++;
                    }
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

    private boolean checkHorizontal(List<String> lines, int i, int j) {

        //this could be achieved by going for sub
        System.out.println("Start testing for: " + lines.get(i).substring(j) +" length: " + lines.get(i).length() + " j value: " + j);
        //first, check if there is enough space for forward xmas, given j position
        if(j<(lines.get(i).length()-4)) {
            System.out.println("FORWARD: i "+ i + " j " + j + "String to be checked: " + lines.get(i).substring(j,j+4));
            if(lines.get(i).substring(j,j+4).equals(("XMAS")))  {
                return true;
            }
        }
        //check if there is enough space for backwards xmas (samx), given j position
        System.out.println("BACK TEST:");
        if(j>=4) {
            System.out.println("BACKWARDS: i "+ i + " j " + j + "String to be checked: " + lines.get(i).substring(j-4,j));
            if(lines.get(i).substring(j-4,j).equals(("SAMX"))) {
                return true;
            }
        }
        return false;
    }


}
