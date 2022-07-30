package Leetcode.Miscellaneous;

public class Count_Unhappy_Friends {
    // SHIT PROBLEM
    // Not solved by self
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] map = new int[n];
        for(int[] pair: pairs)
        { 
            // Keep record of current matches.
            map[pair[0]] = pair[1];
            map[pair[1]] = pair[0];
        }
        
        int res = 0;
        // O(1) to check is some x is more preffered than y
        // Building up the preferences map
        Map<Integer, Integer>[] prefer = new Map[n];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n-1; j++)
            {
                if(prefer[i] == null) prefer[i] = new HashMap<>();
                prefer[i].put(preferences[i][j], j);
            }
        }
        for(int i = 0; i<n; i++)
        {
            for(int j : preferences[i])
            {
                if(prefer[j].get(i) < prefer[j].get(map[j])  && prefer[i].get(map[i]) > prefer[i].get(j)) // Crux of the problem is checking this.
                {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
