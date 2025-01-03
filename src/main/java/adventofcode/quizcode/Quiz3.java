package adventofcode.quizcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Quiz3 implements Quiz{

    //regex to match mul(<number>,<number>). to avoid weird numbers,
    // they can be either 0, or 1 to 9 followed by up to two other digits ranging from 0 to 9
    private final String instructionRegex = "mul\\((0|[1-9][0-9]{0,2}),(0|[1-9][0-9]{0,2})\\)";
    private final String doDontRegex = "do\\(\\)|don't\\(\\)";
    @Override
    public long solvePart1(String filename) {

        //declaring and initializing variables
        List<String> lines;
        lines = getLines(filename);
        long result = 0;


        for(String line : lines) {
            //iterate over line to find all matches according to regex
            Matcher matches = extractValidInstructions(line);
            //iterate over all found matches
            while(matches.find()) {
                //as matcher divides by groups, and first and second group directly represents the numbers (each group
                // is determined by parenthesis. 0 is whole thing, 1 is first parenthesis in regex, and so on...
                //we can use this to get the integers directly
                result += (long) parseInt(matches.group(1)) * parseInt(matches.group(2));
            }
        }

        return result;
    }
    @Override
    public long solvePart2(String filename) {
        //declaring and initializing variables
        List<String> lines;
        lines = getLines(filename);
        long result = 0;
        boolean doEnabled = true;

        for(String line : lines) {
            //iterate over line to find all matches according to regex, including do() and don't()
            Matcher matches = extractValidInstructionsAndDoAndDont(line);
            //iterate over all found matches
            while(matches.find()) {
                //using the previous technique would not work as the grouping would be different, since it got
                //more possible matches that may not contain the numbers.
                //so, I'll check the string by how it starts, and act accordingly
                //group 0 is the whole content of the matched string
                if(matches.group(0).startsWith("mul")) {
                    if (doEnabled) {
                        result += (long) parseInt(matches.group(1)) * parseInt(matches.group(2));
                    }
                } else if (matches.group(0).equals("do()")) {
                    doEnabled = true;
                } else if (matches.group(0).equals("don't()")) {
                    doEnabled = false;
                }
            }
        }

        return result;
    }

    private Matcher extractValidInstructions(String input) {
        //apply pattern to line, and save it to matcher so it can be iterated
        return Pattern.compile(instructionRegex).matcher(input);
    }
    private Matcher extractValidInstructionsAndDoAndDont(String input) {
        //apply pattern to line, and save it to matcher so it can be iterated
        return Pattern.compile(instructionRegex + "|" + doDontRegex).matcher(input);
    }
}
