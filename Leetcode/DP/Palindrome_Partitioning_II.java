package Leetcode.DP;

/*
    Idea (O(n^3) --> TLE) -->  https://anonfiles.com/X7V1c3Nfuf/Palindrome_Partitioning_pdf


    Optimization : 1) Store whether s[i...j] is palindrome or not in O(n^2)
                   2) Only make a partition if left side is palindrome.
                   3) If left side is palin, find minCost for partitioning left half and 
                      add 1(for left half) in the final answer
    
    Final --> O(n^2)
*/

public class Palindrome_Partitioning_II {
    int dp[][];
    boolean palin[][];
    int minCuts(int i, int j, String s)
    {
        if(i == j)return 0;
        if(i+1==j) return (s.charAt(i)==s.charAt(j))?0:1;
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(palin[i][j])return dp[i][j] = 0;
        int mini = Integer.MAX_VALUE/2;
        for(int p = i;p<j; p++)
        {
            if(palin[i][p])
            mini = Math.min(mini, minCuts(p+1,j,s));
        }
        return dp[i][j] = mini + 1;   
    }
    public int minCut(String str) {
        int len = str.length();
        //char s[] = str.toCharArray();
        dp = new int[len][len];
        palin = new boolean[len][len];
        
        buildPalinCheck(str);
            
        for(int a[]:dp) Arrays.fill(a,-1);
        return minCuts(0,len-1,str);
    }
    public void buildPalinCheck(String str)
    {
        int len = str.length();
        for(int p=0; p<len; p++)
        {
            for(int i =0,j=p;j<len;i++,j++)
            {
                if(p<=1)
                {
                    palin[i][j] = str.charAt(i)==str.charAt(j);
                }
                else
                {
                    palin[i][j] = str.charAt(i)==str.charAt(j) && palin[i+1][j-1];
                }
            }
        }
    }
}
