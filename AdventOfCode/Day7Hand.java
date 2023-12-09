import java.util.Arrays;

public class Day7Hand {
    private long value;
    private long[] extendedValue = new long[6];
    private String raw;
    private int bid;
    private int rank = Integer.MAX_VALUE;
    private int[] eachValue;

    //private Day7Hand(){}

    public Day7Hand(String raw, int bid){
        this.raw = raw;
        this.calculateValue(raw);
        this.calculateExtendedValue();
        this.bid = bid;
    }
    public int getBid(){
        return this.bid;
    }
    public long getValue(){
        return this.value;
    }
    public String getRaw(){
        return this.raw;
    }
    public long[] getExtendedValue(){
        return this.extendedValue;
    }
    private void calculateExtendedValue(){
        this.extendedValue[0] = this.value;
        for(int i=0; i<raw.length(); i++){
            this.extendedValue[i+1] = switch(this.raw.charAt(i)){
                case 'A' -> 13;
                case 'K' -> 12;
                case 'Q' -> 11;
                case 'J' -> 10;
                case 'T' -> 9;
                default -> Character.getNumericValue(this.raw.charAt(i)) - 1;
            };
        }
    }
    private void calculateValue(String raw){
        int[] valueInstances = new int[13];
        for(char charNumber : this.raw.toCharArray()){
            switch(charNumber){
                case 'A': valueInstances[12]++; break;
                case 'K': valueInstances[11]++; break;
                case 'Q': valueInstances[10]++; break;
                case 'J': valueInstances[9]++;  break;
                case 'T': valueInstances[8]++;  break;
                default: valueInstances[Character.getNumericValue(charNumber)-2]++; break;
            }
        }

        int pairs = 0;
        int trips = 0;
        for(int instances: valueInstances){
            switch(instances){
                case 5: this.value = 7; return;
                case 4: this.value = 6; return;
                case 3: trips++; break;
                case 2: pairs++; break;
                
            }
        }

        if(trips==1&&pairs==1){
            this.value = 5;
            return;
        }
        if(trips==1){
            this.value = 4;
            return;
        }
        if(pairs==2){
            this.value = 3;
            return;
        }
        if(pairs==1){
            this.value = 2;
            return;
        }
        
        this.value = 1;
        return;
    }
    public boolean greaterThan(Day7Hand elem2){
        long[] elem1Vals = this.getExtendedValue();
        long[] elem2Vals = elem2.getExtendedValue();

        for(int i=0; i<elem1Vals.length; i++){
            if((int)elem1Vals[i] > (int)elem2Vals[i]){
                return true;
            }
            if((int)elem1Vals[i] < (int)elem2Vals[i]){
                return false;
            }

        }
        //else,
        return false;
    }
    public String toString(){
        return this.raw + "\t" + Arrays.toString( this.getExtendedValue());
    }
}
