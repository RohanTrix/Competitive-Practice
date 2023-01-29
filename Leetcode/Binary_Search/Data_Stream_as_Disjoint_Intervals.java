import java.util.TreeMap;
// IDEA : Same as Discuss
public class SummaryRanges {
    TreeMap<Integer, Interval> tm;
    public SummaryRanges() {
        tm = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(tm.containsKey(val)) return;

        Integer lowKey = tm.lowerKey(val);
        Integer highKey = tm.higherKey(val);
        if(lowKey!=null && highKey!=null && tm.get(lowKey).end+1==val && highKey-1==val){
            tm.put(lowKey, new Interval(lowKey, tm.get(highKey).end));
            tm.remove(highKey);
        }
        else if(lowKey!=null && tm.get(lowKey).end+1>=val) {
            Interval lowInt = tm.get(lowKey);
            tm.put(lowKey, new Interval(lowKey, Math.max(lowInt.end, val)));
        }
        else if(highKey!=null && highKey-1==val) {
            tm.put(val, new Interval(val, tm.get(highKey).end));
            tm.remove(highKey);
        }
        else {
            tm.put(val, new Interval(val, val));
        }
        
    }
    
    public int[][] getIntervals() {
        return tm.values().stream()
            .map(interval -> new int[] {interval.start, interval.end})
            .toArray(int[][]::new);
        
    }
    public record Interval(int start, int end){}
}