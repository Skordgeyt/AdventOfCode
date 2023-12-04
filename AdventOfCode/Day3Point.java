package AdventOfCode;

public class Day3Point {
    private int value;
    private int starIndex;

    public Day3Point(){
        this.value = 0;
        this.starIndex = -1;
    }
    public Day3Point(int value, int starIndex){
        this.value = value;
        this.starIndex = starIndex;
    }

    public int getValue(){
        return this.value;
    }
    public int getStarIndex(){
        return this.starIndex;
    }

    public void setValue(int value){
        this.value = value;
    }
    public void setStarIndex(int starIndex){
        this.starIndex = starIndex;
    }
    
    public String toString(){
        return this.value+", nearest gear @ i="+starIndex;
    }
}
