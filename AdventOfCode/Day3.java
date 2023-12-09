
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;
public class Day3 {
    public static void main(String[] args) throws IOException{
        Scanner fileReader = new Scanner(new File("AdventOfCode\\day3input.txt"));
        String rawFileInput = "";
        while(fileReader.hasNextLine()){ rawFileInput += fileReader.nextLine()+"\n"; }

        //replace all punctuation chars (except . of course) with 'x'
        Pattern charReplacement = Pattern.compile("[^0-9^.^\n]"); 
        Matcher replacer = charReplacement.matcher(rawFileInput);
        while(replacer.find()){ rawFileInput = rawFileInput.replace(replacer.group(),"x"); }
       
        //split each line apart, and determine their length.
        String[] everyLine = rawFileInput.split("\n");
        int lineLength = everyLine[0].length();


        //search for numbers of any length, and begin tracking the total sum
        Pattern numberPattern = Pattern.compile("[0-9]+");
        Matcher numberFinder = numberPattern.matcher(rawFileInput);
        long idSum = 0;
        while(numberFinder.find()){
            //System.err.println(numberFinder.group()+" @ "+numberFinder.start());
            String toConsider = "";

            //this block will attempt to add the range above, around, and below the target to toConsider, and then check
            //if a 'x' occurs within those combined ranges. The |s, while placeholders, do not interfere with the algorithm.
            try{
                toConsider += rawFileInput.substring( 
                    (numberFinder.start() - (lineLength+2)), 
                    (numberFinder.start() - (lineLength+2) + (numberFinder.group().length() + 2))
                );
                toConsider+="|";
            }catch(Exception e){}
            try{
                toConsider += rawFileInput.substring( 
                    (numberFinder.start() - 1), 
                    (numberFinder.start() + (numberFinder.group().length() + 1))
                );
                toConsider+="|";
            }catch(Exception e){}
            try{
                toConsider += rawFileInput.substring( 
                    (numberFinder.start() + (lineLength)), 
                    (numberFinder.start() + (lineLength) + (numberFinder.group().length() + 2))
                );
            }catch(Exception e){}

            if(toConsider.indexOf("x")>-1){
                idSum += Integer.parseInt(numberFinder.group());
                System.err.print("ADDED "+numberFinder.group()+":  ");
            }
            System.err.println(numberFinder.group()+", "+toConsider);
        }
        System.err.println(idSum);    
    }
}