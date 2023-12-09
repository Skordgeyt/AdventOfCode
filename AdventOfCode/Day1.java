

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;
import java.util.HashMap;
import java.lang.StringBuilder;
public class Day1{

    public static void main(String[] args) throws IOException{
        Scanner fileReader = new Scanner(new File("AdventOfCode\\day1input.txt"));

        long sum = 0;
        HashMap<String,Integer> numericStrings = new HashMap<String,Integer>(); 
        numericStrings.put("zero",0);
        numericStrings.put("one",1);
        numericStrings.put("two",2);
        numericStrings.put("three",3);
        numericStrings.put("four",4);
        numericStrings.put("five",5);
        numericStrings.put("six",6);
        numericStrings.put("seven",7);
        numericStrings.put("eight",8);
        numericStrings.put("nine",9);

        Pattern numericString = Pattern.compile("zero|one|two|three|four|five|six|seven|eight|nine");
        Pattern reverseNumericString = Pattern.compile("orez|eno|owt|eerht|ruof|evif|xis|neves|thgie|enin");
        

        while(fileReader.hasNextLine()){
            String currentLine = fileReader.nextLine();
            Matcher matcher = numericString.matcher(currentLine);
            
            char dig1; char dig2;

            int i = 0;
            while(!Character.isDigit(currentLine.charAt(i))){i++;}
            dig1 = currentLine.charAt(i);

            i = currentLine.length()-1;
            while(!Character.isDigit(currentLine.charAt(i))){i--;}
            dig2 = currentLine.charAt(i);
            
            String reverse = new StringBuilder(currentLine).reverse().toString();
            Matcher revMatcher = reverseNumericString.matcher(reverse);
            if(revMatcher.find()&&revMatcher.start()<reverse.indexOf(dig2)){
                reverse = reverse.replaceAll(revMatcher.group(),""+numericStrings.get(new StringBuilder(revMatcher.group()).reverse().toString()));
            }

            currentLine = new StringBuilder(reverse).reverse().toString();
            
            matcher = numericString.matcher(currentLine);
            while(matcher.find()){
                currentLine = currentLine.replaceAll(matcher.group(),""+numericStrings.get(matcher.group()));
            }

            i = 0;
            while(!Character.isDigit(currentLine.charAt(i))){i++;}
            dig1 = currentLine.charAt(i);

            i = currentLine.length()-1;
            while(!Character.isDigit(currentLine.charAt(i))){i--;}
            dig2 = currentLine.charAt(i);

            sum += Integer.parseInt(""+dig1+dig2);
        }
        System.err.println(sum);
    }
}