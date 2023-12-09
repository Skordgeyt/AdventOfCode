

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) throws IOException{
        final String SOURCE = "day5input.txt";


        Scanner fileReader = new Scanner(new File(SOURCE));
        fileReader.next(); //remove "seed: "
        ArrayList<Long> seeds = new ArrayList<Long>();
        while(fileReader.hasNextLong()){
            seeds.add(fileReader.nextLong());
        }

        //System.err.println(seeds);

        
        int currentMap = 0;

        Day5Map seedToSoil            = new Day5Map();
        Day5Map soilToFertilizer      = new Day5Map();
        Day5Map fertilizerToWater     = new Day5Map();
        Day5Map waterToLight          = new Day5Map();
        Day5Map lightToTemperature    = new Day5Map();
        Day5Map temperatureToHumidity = new Day5Map();
        Day5Map humidityToLocation    = new Day5Map();

        while(fileReader.hasNextLine()){
            String currentLine = fileReader.nextLine();
            if(currentLine.length()==0){
                continue;
            }
            if(!Character.isDigit(currentLine.charAt(0))){
                currentMap++;
                continue;
            }
            //System.err.println(currentMap+"  "+currentLine);
            Scanner currentLineScanner = new Scanner(currentLine);
            long destination = currentLineScanner.nextLong();
            long lowerBound  = currentLineScanner.nextLong();
            long range       = currentLineScanner.nextLong();

            switch(currentMap){
                case 1:seedToSoil            .put(new Day5Range(destination,lowerBound,range)); break;
                case 2:soilToFertilizer      .put(new Day5Range(destination,lowerBound,range)); break;
                case 3:fertilizerToWater     .put(new Day5Range(destination,lowerBound,range)); break;
                case 4:waterToLight          .put(new Day5Range(destination,lowerBound,range)); break;
                case 5:lightToTemperature    .put(new Day5Range(destination,lowerBound,range)); break;
                case 6:temperatureToHumidity .put(new Day5Range(destination,lowerBound,range)); break;
                case 7:humidityToLocation    .put(new Day5Range(destination,lowerBound,range)); break;
            }
        }

        long lowestResult = Long.MAX_VALUE;
        for(long seed: seeds){
            //shoot me
            long result = humidityToLocation.give(
                temperatureToHumidity.give(
                    lightToTemperature.give(
                        waterToLight.give(
                            fertilizerToWater.give(
                                soilToFertilizer.give(
                                    seedToSoil.give(seed)
                                )
                            )
                        )
                    )
                )
            );
            lowestResult = Long.min(result,lowestResult);
        }

        System.err.println(lowestResult);
    }
}

