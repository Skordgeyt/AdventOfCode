import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Day15{
    public static void main(String[] args) throws IOException{
        final String SOURCE = "AdventOfCode//day15input.txt";

        Scanner fileReader = new Scanner(new File(SOURCE));

        ArrayList<String> allCodes = new ArrayList<String>();
        fileReader.useDelimiter(",");
        while(fileReader.hasNext()){
            allCodes.add(fileReader.next().trim());
        }
        
        
        System.out.println(allCodes);

        long totalSum = 0;
        for(String elem: allCodes){
            totalSum += hash(elem);
        }

        System.out.println(totalSum);
    }
    public static int hash(String in){

            int currentValue = 0;
            for(char letter: in.toCharArray()){
                currentValue += (int) letter;
                currentValue *= 17;
                currentValue %= 256;
            }
            return currentValue;
        }
    
}