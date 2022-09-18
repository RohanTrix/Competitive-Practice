package Leetcode.Miscellaneous;

// IDEA : Keep forming the continuous string till you can. When you cannot, resent the count.
//        At each step, take the max of the continuous substring length.
public class Length_of_the_Longest_Alphabetical_Continuous_Substring {
    public int longestContinuousSubstring(String s) {
        char str[] = s.toCharArray();
        int maxi = 1, cnt = 1;
        for(int i = 1; i<s.length(); i++)
        {
            if(str[i] == str[i-1]+1) cnt++;
            else
                cnt = 1;
            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }
}
