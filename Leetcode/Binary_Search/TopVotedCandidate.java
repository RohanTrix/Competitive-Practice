package Leetcode.Binary_Search;

import java.util.TreeMap;

public class TopVotedCandidate {
    // Times can go upto 10^9 but length of the array can only be uptil 5000.
    // So we keep a TreeMap mapping time -> winner at that time.
    // And since the time array is sorted, we keep a running freq arr for votes...and as soon as a winner changes, we update it
    // in the treemap
    // For query..we want to find the lower_bound (floor) of the time.
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        int n = times.length;
        int maxVotes = 0, winner = -1;
        int votes[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            votes[persons[i]]++;
            if(maxVotes<=votes[persons[i]])
            {
                maxVotes = votes[persons[i]];
                map.put(times[i], persons[i]);
            }
        }
    }
    
    public int q(int t) {
        return map.get(map.floorKey(t));
    }
}
