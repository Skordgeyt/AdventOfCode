import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9 {
    public static void main(String[] args) throws IOException {
        final String SOURCE = "AdventOfCode//day9input.txt";
        Scanner fileReader = new Scanner(new File(SOURCE));

        long total = 0;
        while (fileReader.hasNextLine()) {
            Scanner lineReader = new Scanner(fileReader.nextLine());

            ArrayList<Integer> currentList = new ArrayList<Integer>();
            while (lineReader.hasNextInt()) {
                currentList.add(lineReader.nextInt());
            }

            int next = predictNext(currentList);
            total += currentList.get(currentList.size() - 1) + (predictNext(currentList));
        }
        System.err.println(total);
    }

    // This does one LESS step than expected.
    public static int predictNext(ArrayList<Integer> list) {

        ArrayList<Integer> differenceList = new ArrayList<Integer>();
        for (int i = 0; i < list.size() - 1; i++) {
            differenceList.add(list.get(i + 1) - list.get(i));
        }

        System.out.println(differenceList);

        if (allZero(differenceList)) {
            return 0;
        }
        return differenceList.get(differenceList.size() - 1) + predictNext(differenceList);
    }

    public static boolean allZero(ArrayList<Integer> list) {
        for (Integer elem : list) {
            if(elem!=0){
                return false;
            }
        }
        return true;
    }
}
