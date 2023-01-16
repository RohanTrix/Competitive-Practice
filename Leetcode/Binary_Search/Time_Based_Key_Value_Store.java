package Leetcode.Binary_Search;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

// IDEA : For a key's given timestamps, binary search the timestamp's floor
class Time_Based_Key_Value_Store {
    Map<String, TreeSet<pair>> map;
    public Time_Based_Key_Value_Store() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.computeIfAbsent(key, k-> new TreeSet<>()).add(new pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        pair ans = map.get(key).floor(new pair("", timestamp));
        return ans==null?"":ans.val;
    }
    class pair implements Comparable<pair>
    {
        String val; int time;
        public pair(String val, int time)
        {
            this.val = val;
            this.time = time;
        }
        public int compareTo(pair p)
        {
            return time - p.time;
        }
        public boolean equals(Object o)
        {
            pair p = (pair) o;
            return val == p.val && time == p.time;
        }
        public int hashCode()
        {
            return Objects.hashCode(val)^Objects.hashCode(time);
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */