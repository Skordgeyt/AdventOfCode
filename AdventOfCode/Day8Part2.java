/*
 * this problem kinda sucks tbh. had to check the AoC reddit to see that you can use LCM.
 * there's no way without some giant guesses or complicated checks to know that would work.
 * very icky
 */


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Day8Part2 {
    public static void main(String[] args) throws IOException{
        final String SOURCE = "day8input.txt";
        Scanner fileReader = new Scanner(new File(SOURCE));

        char[] directions = fileReader.nextLine().trim().toCharArray();
        fileReader.nextLine(); //clear empty line

        HashMap<String,Day8Fork> forkList = new HashMap<String,Day8Fork>();
        //read and parse all input into HashMap
        while(fileReader.hasNextLine()){
            String currentLine = fileReader.nextLine();
            String source = currentLine.substring(0,3);
            String left = currentLine.substring(7, 10);
            String right = currentLine.substring(12, 15);
            forkList.put(source, new Day8Fork(left,right));
            //System.err.println(String.format("S: %s, L: %s, R: %s",source,left,right));
        }

        //generate a list of all beginning keys
        ArrayList<String> allSources = new ArrayList<String>();
        for(String source: forkList.keySet()){
            if(source.charAt(2)=='A'){
                allSources.add(source);
            }
        }
        

        //i is used to count steps, index is position in the directions[] array
        
        long[] steps = new long[allSources.size()];

        for(int a = 0; a<steps.length; a++){
            String currentSource = allSources.get(a);
            int index = 0;

            for(int i=1; /* */; i++){
                //account for overflow
                if(index==directions.length){
                    index = 0;
                }
    
    
                //System.err.println(allSources);
    
    
                if(directions[index]=='L'){
                    currentSource = forkList.get(currentSource).left();
                }
                else{
                    currentSource = forkList.get(currentSource).right();
                }
    
    
                if(currentSource.charAt(2)=='Z'){
                    steps[a] = i;
                    break;
                }
    
                index++;
            }
        }

        long lcm = lcm(steps[0],steps[1]);
        for(int i=2; i<steps.length; i++){
            lcm = lcm(lcm,steps[i]);
        }
        System.err.println(lcm);
    }
    public static long lcm(long num1,long num2){
        long high= Long.max(num1,num2);
        long low = Long.min(num1,num2);
        long lcm = high;
        while(lcm % low != 0){
            lcm+=high;
        }
        return lcm;
    }
}