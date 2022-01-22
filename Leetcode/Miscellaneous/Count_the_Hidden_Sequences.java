// REFER : https://leetcode.com/problems/count-the-hidden-sequences/discuss/1709710/C%2B%2B-One-pass-O(N)-time
public class Count_the_Hidden_Sequences {
    
    public int numberOfArrays(int[] diff, int lower, int upper) {
        long mini = 0;
        long maxi = 0;
        long ai = 0;
        for(int i : diff)
        {
            ai+=i;
            mini = Math.min(mini, ai);
            maxi = Math.max(maxi, ai);
        }
        long uprange = upper - maxi;
        long downrange = mini - lower;
        long totElements = uprange + downrange  + 1L;
        return (int)Math.max(totElements, 0);
    }
}