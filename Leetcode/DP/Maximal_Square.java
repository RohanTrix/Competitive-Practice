class Maximal_Square {
    // REFER : https://youtu.be/oPrpoVdRLtg
    public int maximalSquare(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][m];
        int maxi = 0;
        for(int i = 0; i<n; i++){dp[i][0] = mat[i][0]-'0';maxi = Math.max(maxi,dp[i][0]);}
        for(int i = 0; i<m; i++){dp[0][i] = mat[0][i]-'0';maxi = Math.max(maxi,dp[0][i]);}
        
        for(int i =1; i<n; i++)
        {
            for(int j = 1; j<m; j++)
            {
                dp[i][j] = mat[i][j]-'0';// Set 1 or 0 depending on cell
                if(mat[i][j]=='0')continue;
                dp[i][j] +=Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                maxi = Math.max(maxi,dp[i][j]);
    
            }
        }
        return maxi*maxi;
    }
}