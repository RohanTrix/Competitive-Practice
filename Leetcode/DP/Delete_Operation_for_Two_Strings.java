package Leetcode.DP;

class Delete_Operation_for_Two_Strings {
    /*
    The problem is nothing but finding the longest common subsequence in for the two strings. The answer 
    is (len of s1 - len of LCS) + (len of s2 - len of LCS) 
    */
    public int minDistance(String word1, String word2) {
        char w1[] = word1.toCharArray();
        char w2[] = word2.toCharArray();
        int len1 = w1.length;
        int len2 = w2.length;
        int dp[][] = new int[len1+1][len2+1];
        Arrays.fill(dp[0], 0);
        for( int i =0; i<=len1; i++) dp[i][0] = 0;
        for( int i = 1;i<=len1;i++)
        {
            for( int j =1; j<=len2;j++)
            {
                if(w1[i-1]==w2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return len1+len2-2*dp[len1][len2];
    }
}
