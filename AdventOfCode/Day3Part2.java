
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
public class Day3Part2 {
    public static void main(String[] args) throws IOException{
        Scanner fileReader = new Scanner(new File("AdventOfCode\\day3input.txt"));
        String rawFileInput = "";
        while(fileReader.hasNextLine()){ rawFileInput += fileReader.nextLine()+"\n"; }

        //replace all irrelevant punctuation chars with '.'
        Pattern charReplacement = Pattern.compile("[^0-9^.^\n^*]"); 
        Matcher replacer = charReplacement.matcher(rawFileInput);
        while(replacer.find()){ rawFileInput = rawFileInput.replace(replacer.group(),"."); }
       
        //split each line apart, and determine their length.
        String[] everyLine = rawFileInput.split("\n");
        int lineLength = everyLine[0].length();


        //search for numbers of any length, and begin tracking the total sum
        Pattern numberPattern = Pattern.compile("[0-9]+");
        Matcher numberFinder = numberPattern.matcher(rawFileInput);
        ArrayList<Day3Point> gearList = new ArrayList<Day3Point>();

        while(numberFinder.find()){
            
            Day3Point currentPoint = new Day3Point();
            currentPoint.setValue( Integer.parseInt(numberFinder.group()) );
            
            //the following code blocks identify if there is a star around the found number, and places those values
            //in a day3point object. the comment blocks are left from part 1 to explain the parameters of the for loops.
            try{
                for(int i = (numberFinder.start() - (lineLength+2)); i<(numberFinder.start() - (lineLength+2) + (numberFinder.group().length() + 2)); i++){
                    if(rawFileInput.charAt(i)=='*'){
                        currentPoint.setStarIndex(i);
                    }
                }
                // toConsider += rawFileInput.substring( 
                //     (numberFinder.start() - (lineLength+2)), 
                //     (numberFinder.start() - (lineLength+2) + (numberFinder.group().length() + 2))
                // );
                
            }catch(Exception e){}
            try{
                for(int i = (numberFinder.start() - 1); i<(numberFinder.start() + (numberFinder.group().length() + 1)); i++){
                    if(rawFileInput.charAt(i)=='*'){
                        currentPoint.setStarIndex(i);
                    }
                }
                // toConsider += rawFileInput.substring( 
                //     (numberFinder.start() - 1), 
                //     (numberFinder.start() + (numberFinder.group().length() + 1))
                // );
                
            }catch(Exception e){}
            try{
                for(int i = (numberFinder.start() + (lineLength)); i<(numberFinder.start() + (lineLength) + (numberFinder.group().length() + 2)); i++){
                    if(rawFileInput.charAt(i)=='*'){
                        currentPoint.setStarIndex(i);
                    }
                }
                // toConsider += rawFileInput.substring( 
                //     (numberFinder.start() + (lineLength)), 
                //     (numberFinder.start() + (lineLength) + (numberFinder.group().length() + 2))
                // );
            }catch(Exception e){}

            gearList.add(currentPoint);
            
        }  

        for(int i=gearList.size()-1; i>=0; i--){
            if(gearList.get(i).getStarIndex() == -1){
                gearList.remove(i);
            }
        }

        //find index matches, multiply their corresponding values, and remove them.
        long totalSum = 0;
        while(gearList.size()>1){
            int currentIndex = gearList.get(0).getStarIndex();

            for(int i=1; i<gearList.size(); i++){
                if(gearList.get(i).getStarIndex()==currentIndex){
                    totalSum += (  gearList.get(i).getValue()  *  gearList.get(0).getValue());
                    gearList.remove(i);
                    break;
                }
            }
            gearList.remove(0);
        }

        System.err.println(totalSum);
    }
}