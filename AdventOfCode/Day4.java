package AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws IOException{
        final String SOURCE = "AdventOfCode\\day4input.txt";
        Scanner fileReader = new Scanner(new File(SOURCE));

        long total = 0;

        //count lines and create a int[] to store how many copies they have. cardCopies[0] is NOT used
        Scanner lineCounter = new Scanner(new File(SOURCE));
        int lineLength = 0;
        for(/**/; lineCounter.hasNextLine(); lineLength++ ){
            lineCounter.nextLine();
        }
        int[] cardCopies = new int[lineLength+1];
        Arrays.fill(cardCopies,1);

        //IMPORTANT 
        cardCopies[0] = 0;


        for(int currentGame = 1; fileReader.hasNextLine(); currentGame++){
            //get current line, remove game #
            String currentLine = fileReader.nextLine();
            //int gameID = Integer.parseInt(currentLine.substring(   
            //    currentLine.indexOf(" "),
            //    currentLine.indexOf(":"))
            //    .trim());
            currentLine = currentLine.substring(currentLine.indexOf(":")+1).trim();
            

            //grab the cards, transfer them into ALs. Using scanners so as to avoid parsing from a string.
            Scanner winningCardScanner = new Scanner(currentLine.substring(0,currentLine.indexOf("|")));
            Scanner ourCardScanner = new Scanner(currentLine.substring(currentLine.indexOf("|")+1));
            ArrayList<Integer> winningCards = new ArrayList<Integer>();
            ArrayList<Integer> ourCards = new ArrayList<Integer>();
            while(winningCardScanner.hasNextInt()){
                winningCards.add(winningCardScanner.nextInt());
            }
            while(ourCardScanner.hasNextInt()){
                ourCards.add(ourCardScanner.nextInt());
            }
            
            int matches = 0;
            for(Integer ourCard: ourCards){
                for(Integer winningCard: winningCards){
                    if(ourCard.equals(winningCard)){ matches++; }
                }
            }
            
            //for the (matches) following cards, increase their copies * this card's copies many times
            for(int i=1; i<=matches; i++){
                cardCopies[currentGame+i] += cardCopies[currentGame];
            }
            

        }

        for(int elem: cardCopies){
            total += elem;
        }

        System.err.println(Arrays.toString(cardCopies));
        System.err.println(total);
        //System.err.println(lineLength);
        //System.err.println(Math.pow(2,0));
    }
}
