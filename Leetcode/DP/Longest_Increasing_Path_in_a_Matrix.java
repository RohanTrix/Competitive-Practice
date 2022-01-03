package Leetcode.DP;

public class Longest_Increasing_Path_in_a_Matrix {
    // REFER: https://youtu.be/bI27Vnwakxc

    // Explanation in OneNote
    int dp[][];
    int dr[] = {0,0,1,-1};
    int dc[] = {1,-1,0,0};
    public int dfs(int x, int y, int mat[][])
    {
        if(dp[x][y]!=-1) return dp[x][y];
        int maxi = 0;
        for(int i = 0; i<4; i++)
        {
            int nx = x+dr[i], ny = y+dc[i];
            if(nx>=0 && nx<mat.length && ny>=0 && ny<mat[0].length && 
                mat[nx][ny]> mat[x][y])
                maxi = Math.max(maxi, dfs(nx,ny, mat));
        }
        return dp[x][y] = 1 + maxi;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n][m];
        int maxi = 1;
        for(int[] a:dp) Arrays.fill(a,-1);
        for(int i = 0; i<n;i++)
        {
            for(int j = 0; j<m; j++)
            {
                maxi = Math.max(maxi, dfs(i,j,matrix));
            }
        }
        
        return maxi;
    }
}
