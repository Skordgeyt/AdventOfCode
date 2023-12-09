

public class Day5Range {
    private long upperBound;
    private long lowerBound;
    private long destination;

    public Day5Range(){
        upperBound = 0;
        lowerBound = 0;
    }
    public Day5Range(long destination, long lowerBound, long range){
        this.lowerBound = lowerBound;
        this.upperBound = lowerBound + (range-1);
        this.destination = destination;
    }

    public boolean contains(long elem){
        return (lowerBound<=elem&&elem<=upperBound);
    }
    public long give(long source){
        return destination + (source-lowerBound);
    }
}
