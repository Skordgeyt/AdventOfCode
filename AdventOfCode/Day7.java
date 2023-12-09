import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class Day7 {
   public static void main(String[] args) throws IOException{
        final String SOURCE = "day7input.txt";
        Scanner fileReader = new Scanner(new File(SOURCE));

        Day7Hand[] allHands = new Day7Hand[1000];
        for(int i=0; fileReader.hasNextLine(); i++){
            Scanner lineReader = new Scanner(fileReader.nextLine());
            allHands[i] = new Day7Hand(lineReader.next(),lineReader.nextInt());   
        }

        //a shameful implementation of ever-slow bubble sort. feeling very lazy tonight ...zzz
        for(int i=0; i<allHands.length; i++){
            for(int j=1; j<(allHands.length-i); j++){
                if(allHands[j-1].greaterThan(allHands[j])){
                    
                    Day7Hand temp = allHands[j-1];
                    allHands[j-1] = allHands[j];
                    allHands[j] = temp;
                }
            }
        }

        long totalSum = 0;
        for(int i=0; i<allHands.length; i++){
            totalSum += allHands[i].getBid() * (i+1);
        }

        System.err.println(totalSum);
   } 
}
