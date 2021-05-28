class Richest_Customer_Wealth {
    public int maximumWealth(int[][] accounts) {
        int m  =accounts.length;
        int max = Integer.MIN_VALUE, sum =0;
        int n = accounts[0].length;
        for(int i=0;i<m;i++)
        {
            sum = 0;
            for(int j=0;j<n;j++)
            {
                sum+=accounts[i][j];
            }
            max = Math.max(max, sum);
            
        }
        return max;
    }
}