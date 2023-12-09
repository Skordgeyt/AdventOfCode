

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) throws IOException{
        final String SOURCE = "day6input.txt";
        final int RACES = 4; //being lazy for an easy problem. input how many races are being considered manually.
        Scanner fileReader = new Scanner(new File(SOURCE));


        int[] times = new int[RACES];
        int[] distances = new int[RACES];

        fileReader.next();
        for(int i=0; i<RACES; i++){
            times[i] = fileReader.nextInt();
        }

        fileReader.nextLine();
        fileReader.next();
        for(int i=0; i<RACES; i++){
            distances[i] = fileReader.nextInt();
        }

        // System.err.println(Arrays.toString(times) +"\t"+ Arrays.toString(distances));
        
        long totalSum = 1;
        //race loops
        for(int i=0; i<RACES; i++){
            int recordDistance = distances[i];
            int waysToBeat = 0;
            //loop from 1s to max time s
            for(int j = 1; j<times[i]; j++){
                int distance = j * (times[i] - j);
                if(distance>recordDistance){
                    waysToBeat++;
                }
            }
            System.err.println(waysToBeat);
            if(waysToBeat!=0){
                totalSum *= waysToBeat;
            }
        }

        System.err.println(totalSum);
    }
}
