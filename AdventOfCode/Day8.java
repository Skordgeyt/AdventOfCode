import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Day8 {
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
            System.err.println(String.format("S: %s, L: %s, R: %s",source,left,right));
        }



        //i is used to count steps, index is position in the directions[] array
        int index = 0;
        String currentSource = "AAA";
        for(int i=1; /**/; i++){
            //account for overflow
            if(index==directions.length){
                index = 0;
            }

            if(directions[index]=='L'){
                currentSource = forkList.get(currentSource).left();
            }
            else{
                currentSource = forkList.get(currentSource).right();
            }

            System.err.print(currentSource+", ");

            if(currentSource.equals("ZZZ")){
                System.err.println(i);
                break;
            }

            index++;
        }
    }
}
