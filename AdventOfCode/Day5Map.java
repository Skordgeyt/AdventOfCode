

import java.util.ArrayList;

public class Day5Map {
    private ArrayList<Day5Range> ranges = new ArrayList<Day5Range>();

    public Day5Map(){}

    public void put(Day5Range range){
        ranges.add(range);
    }

    public long give(long source){
        for(Day5Range range: ranges){
            if(range.contains(source)){
                return range.give(source);
            }
        }
        return source;
    }
}
