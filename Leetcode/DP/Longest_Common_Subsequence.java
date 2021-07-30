package Leetcode.DP;

import java.util.Arrays;

class Longest_Common_Subsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        
        int LCS[][] = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++)
        {
            LCS[i][0] = 0;
            
        }
        for(int i=0;i<=n2;i++)
        {
            LCS[0][i] = 0;
            
        }
        for(int i=1;i<=n1;i++)
        {
            for(int j=1; j<=n2;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    LCS[i][j] += LCS[i-1][j-1] +1;
                }
                else
                {
                    LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
                }
            }
        }  
        //viewArray2D(LCS);
        return LCS[n1][n2];
    }
    static void viewArray1D(int a[])
    {
        System.out.println(Arrays.toString(a));
    }
    static void viewArray2D(int arr[][])
    {
        for (int[] row: arr)
        viewArray1D(row);
    }
}