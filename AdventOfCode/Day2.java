package AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.lang.StringBuilder;

public class Day2 {
    public static void main(String[] args)throws IOException{
        Scanner fileReader = new Scanner(new File("AdventOfCode\\day2input.txt"));

        long totalSum = 0;
        while(fileReader.hasNextLine()){
            StringBuilder currentLine = new StringBuilder(fileReader.nextLine());

            //get and remove ID section
            int colonIndex = currentLine.indexOf(":");
            //int gameID = Integer.parseInt(
            //    currentLine.substring(0,colonIndex)
            //    .replace("Game ","")
            //); 
            currentLine.delete(0, (colonIndex+2) );
            
            //System.err.println("\n"+currentLine);

            //boolean validGame = true;
            int redMin = 0;
            int bluMin = 0;
            int grnMin = 0;
            for(String set: currentLine.toString().split(";")){
                set = set.trim();
                //System.err.print(set+"\t|\t");
                

                int redSum = 0;
                int bluSum = 0;
                int grnSum = 0;

                for(String hand: set.split(",")){
                    hand = hand.trim();

                    int spaceIndex = hand.indexOf(" ");
                    String color = hand.substring(spaceIndex).trim();
                    //System.err.print("[CURRENTLY: "+color+hand.substring(0,spaceIndex)+"]");
                    int number = Integer.parseInt(hand.substring(0,spaceIndex));

                    switch(color){
                        case "red": redSum += number; break;
                        case "green": grnSum += number; break;
                        case "blue": bluSum += number; break;
                        default:
                    }
                }
                
                if(redSum>redMin){ redMin = redSum;}
                if(grnSum>grnMin){ grnMin = grnSum;}
                if(bluSum>bluMin){ bluMin = bluSum;}
                //System.err.println("red: "+redSum+", blu: "+bluSum+", grn: "+grnSum+",verdict: "+validGame);
            }

            totalSum += (redMin*grnMin*bluMin);  
        }
        System.err.println(totalSum);
    }
}
