package AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) throws IOException{
        final String SOURCE = "AdventOfCode\\day5input.txt";


        Scanner fileReader = new Scanner(new File(SOURCE));
        fileReader.next();
        ArrayList<Long> seeds = new ArrayList<Long>();
        while(fileReader.hasNextLong()){
            seeds.add(fileReader.nextLong());
        }

        //System.err.println(seeds);

        String rawFileString = "";
        
        while(fileReader.hasNextLine()){
            rawFileString += fileReader.nextLine()+"\n";
        }

        Pattern mapNamePattern = Pattern.compile(".+?-to-.+? map:");
        Matcher mapNameFinder = mapNamePattern.matcher(rawFileString);
        while(mapNameFinder.find()){
            System.err.println(mapNameFinder.group());
        }



    }
}

//TODO: FINISH THE PROBLEM, BOZO.