public class Palindrome_Partitioning_III
{
    // Explanation in OneNode Special Problems

    int palinCost[][]; // Stores min number of chars(cost) to change to make s[i...j] palindrome
    int dp[][]; // Stores min cost to make each of k partitions of s[i..n-1] a plaindrome
    public int palindromePartition(String s, int k) {
        buildCostToPalin(s); // Build palinCost
        k--; // We need to partition at k-1 positions to get k partitions
        dp = new int[100][100]; 
        for(int a[]:dp) Arrays.fill(a, Integer.MAX_VALUE);
        return minCost(0, s, k);
    }
    public int minCost(int i, String s, int k)
    {
        //System.out.println(i+" "+k);
        if(k==0)return palinCost[i][s.length()-1]; // If all partitions are made, return cost to make s[i..n-1] a palin
        if(i==s.length()) return Integer.MAX_VALUE/2; // If partitions are left but we are out of characters, so we cannot partition
        if(dp[i][k]!=Integer.MAX_VALUE) return dp[i][k]; // Return DP if we have stored
        int mini = Integer.MAX_VALUE/2; 
        for(int p = i;p<s.length()-1;p++)
        {
            // Explained in OneNote
            mini = Math.min(palinCost[i][p] + minCost(p+1, s, k-1), mini);
        }
        return dp[i][k] = mini;
    }
    public void buildCostToPalin(String str)
    {

        // Explained in OneNote
        int n = str.length();
        char s[] = str.toCharArray();
        palinCost = new int[n][n];
        
        for(int p = 0; p<n; p++)
        {
            for(int i = 0, j = p; j<n; i++,j++)
            {
                if(p<=1)
                    palinCost[i][j] = s[i]==s[j]?0:1;
                else
                    palinCost[i][j] = (s[i]==s[j]?0:1) + palinCost[i+1][j-1];
            }
        }
    }
}