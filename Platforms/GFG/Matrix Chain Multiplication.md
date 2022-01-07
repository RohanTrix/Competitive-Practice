## Refer Coding Blocks

```java
class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        ArrayList<int[]> mat = new ArrayList<int[]>();
        for(int i = 0; i<N-1; i++)
        {
            mat.add(new int[]{arr[i],arr[i+1]});
        }
        N--;
        int dp[][] = new int[N][N];
        
        for(int i = 0; i<N; i++)
            dp[i][i] = 0;
        
        for(int i=0; i<N-1; i++)
        {
            dp[i][i+1] = mat.get(i)[0]*mat.get(i)[1]*mat.get(i+1)[1];
        }
        
        for(int p = 2; p<N;p++)
        {
            for(int l =0, r=p; r<N; l++,r++)
            {
                int mini = Integer.MAX_VALUE/2;
                for(int mid = l; mid < r; mid++)
                {
                    int mulCost = mat.get(l)[0]*mat.get(mid)[1]*mat.get(r)[1];
                    int val = dp[l][mid]+dp[mid+1][r] + mulCost;
                    mini = Math.min(mini,val);
                }
                dp[l][r] = mini;
            }
        }

        return dp[0][N-1];
    }
}
```