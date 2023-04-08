import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    Map<Integer, Mark> checkMap; // Maps ID --> (station checked into, time of check in)
    Map<String, Avg> avgMap; // Maps <startStation#endStation> --> (Sum of times taken on all trips, cnt of trips)
    public UndergroundSystem() {
        checkMap = new HashMap<>();
        avgMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkMap.put(id, new Mark(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Mark lastLocation = checkMap.get(id);
        int timeTaken = t - lastLocation.time;
        String path = lastLocation.stationName + '#' + stationName;
        Avg oldAvg = avgMap.getOrDefault(path, new Avg(0,0));
        Avg newAvg = new Avg(oldAvg.sum + timeTaken, oldAvg.cnt+1);
        avgMap.put(path, newAvg);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Avg avg = avgMap.get(startStation+'#'+endStation);
        return (1.0*avg.sum)/avg.cnt;
    }
    public record Mark(String stationName, int time) {}
    public record Avg(int sum, int cnt){}
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */