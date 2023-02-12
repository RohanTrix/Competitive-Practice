import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Freedom_Trail {
    Integer dp[][];
    Map<Character, List<Integer>> map;
    char r[], k[];
    int keyLen, ringLen;
    public int minSteps(int i, int pos) {
        if(i == keyLen) return 0;
        if(dp[i][pos]!=null) return dp[i][pos];
        int mini = Integer.MAX_VALUE/2;
        for(int to : map.get(k[i])) {

            int path1 = Math.abs(pos - to);
            int path2 = ringLen - path1;
            int minPath = Math.min(path1, path2);
            mini = Math.min(mini, 1 + minPath + minSteps(i+1, to));
        }
        return dp[i][pos] = mini;
    }
    public int findRotateSteps(String ring, String key) {
        r = ring.toCharArray();
        k = key.toCharArray();
        ringLen = r.length; keyLen = k.length;
        map = new HashMap<>();
        for(int i = 0; i<ringLen; i++)
            map.computeIfAbsent(r[i], p-> new ArrayList<>()).add(i);
        dp = new Integer[keyLen][ringLen];
        return minSteps(0, 0);
    }
}