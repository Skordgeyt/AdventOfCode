import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day6Part2 {
    //quite possibly easier than part 1. lol. lmao, even.
    public static void main(String[] args) throws IOException{
        final String SOURCE = "day6input.txt";

        Scanner fileReader = new Scanner(new File(SOURCE));

        fileReader.next();
        long time = Long.parseLong(   fileReader.nextLine().replace(" ","").trim()   );
        fileReader.next();
        long recordDistance = Long.parseLong(   fileReader.nextLine().replace(" ","").trim()   );

        System.err.println(time+", "+recordDistance);

        long upperBound = 0;
        long lowerBound = 0;

        //go from 1 forward to find fastest possible
        for(long i = 1; i<time; i++){
            long distance = i * (time - i);
            if(distance>recordDistance){
                lowerBound = i;
            }
        }
        //go from end backwards
        for(long i = time; i>=1; i--){
            long distance = i * (time - i);
            if(distance>recordDistance){
                upperBound = i;
            }
        }
        System.err.println("UPPER BOUND:"+upperBound);
        System.err.println("LOWER BOUND:"+lowerBound);
        System.err.println(lowerBound-upperBound+1); //i do not understand why it is lower-upper. I do not know. The +1 is cuz inclusive ranges.
    }
}
