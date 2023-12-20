import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/*
 * In this file, comments were largely underused. 
 * I have left the understanding of this code as an exercise to the reader,
 * and expect this code to be refactored and commented for class on Monday.
 */

public class Day15Part2{
    public static void main(String[] args) throws IOException{
        final String SOURCE = "AdventOfCode//day15input.txt";

        Scanner fileReader = new Scanner(new File(SOURCE));

        ArrayList<String> allCodes = new ArrayList<String>();

        ArrayList<ArrayList<Day15Lens>> boxes = new ArrayList<ArrayList<Day15Lens>>(256);
        for(int i = 0; i<256; i++){
            boxes.add(new ArrayList<Day15Lens>());
        }
        fileReader.useDelimiter(",");
        while(fileReader.hasNext()){
            allCodes.add(fileReader.next().trim());
        }
        
        
        //System.out.println(allCodes);

        long totalSum = 0;
        for(String elem: allCodes){
            String label = (elem.indexOf("-")!=-1)? 
                elem.substring(0,elem.indexOf("-")) : 
                elem.substring(0,elem.indexOf("=")) ;
            System.err.println(label);

            int currentHash = hash(label);
            // - : remove lens
            if(elem.indexOf("-")!=-1){
                for(int i=0; i<boxes.get(currentHash).size(); /* */){
                    if(boxes.get(currentHash).get(i).getLabel().equals(label)){
                        boxes.get(currentHash).remove(i);
                    }
                    else{
                        i++;
                    }
                }
            }
            // = : add lens
            else{
                boolean added = false;

                for(int i=0; i<boxes.get(currentHash).size(); i++){
                    if(boxes.get(currentHash).get(i).getLabel().equals(label)){
                        boxes.get(currentHash).set(i, new Day15Lens( label , Character.getNumericValue(elem.charAt(elem.length()-1))));
                        added=true;
                    }
                    
                }
                if(!added){
                    boxes.get(currentHash).add(new Day15Lens( label , Character.getNumericValue(elem.charAt(elem.length()-1))));
                }

            }
        }

        //TEST OUTPUT
        // for(int i = 0; i<256; i++){
        //     System.err.print(i+":\t[");
        //     for(Day15Lens lens: boxes.get(i)){
        //         System.err.print(lens.toString()+", ");
        //     }
        //     System.err.println("]");
        // }

        long total = 0;
        {
        int i = 0;
        for(ArrayList<Day15Lens> box: boxes){
            int j = 0;
            for(Day15Lens lens: box){
                total += (i+1)*(j+1)*lens.getStrength();
                j++;
            }
            i++;
        }
        }
        System.err.println(total);
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