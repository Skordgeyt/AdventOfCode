package AdventOfCode;

public class Day5Range {
    private int upperBound;
    private int lowerBound;
    private int destination;

    public Day5Range(){
        upperBound = 0;
        lowerBound = 0;
    }
    public Day5Range(int lowerBound, int upperBound, int destination){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.destination = destination;
    }

    public boolean contains(int elem){
        return (lowerBound<=elem&&elem<=upperBound);
    }
    public int give(int source){
        return destination + (source-lowerBound);
    }
}
