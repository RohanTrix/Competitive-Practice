/*
    IDEA : The very low constraints hint towards Bitmask DP. 
    
        TLE APPROACH: I initially used 2 masks, one for each group. And then tried to match 2 nodes in which either one  or both 
                      have not been used yet. That gave me TLE.

       AC APPROACH with a little help from Discuss:
                      
                       We use a variable i to iterate on nodes of the first group. And we try to connect this to any one of the
                       nodes in group 2. After connecting, we update the bitmask and call for the i+1.
                       
                       Tricky Base Case : After we have connected each node i in Group 1, there might be some nodes in group 2 that did
                       not connect to any node in the Group 1. So at this time, we try to attach each of these un-attached 
                       nodes in Group 2 with the min Edge to one of the nodes in Group 1. 
                       
                       This will ensure that each node in Group 2 is now connected, and since we have reached i==size1, we know that
                       all nodes in Group 1 are surely connected to some node in Group 2
*/

public class Minimum_Cost_to_Connect_Two_Groups_of_Points
{
    // Base Case Idea Borrowed from here : 
    //          https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/855041/C%2B%2BPython-DP-using-mask
    int INTMAX = Integer.MAX_VALUE/2;
    List<List<Integer>> cost;
    int size1, size2;
    Integer dp[][];
    int minEdge[];
    public int minCost(int i, int mask2)
    {
        if(i==size1)
        {
            int res = 0;
            for(int j = 0; j<size2; j++)
                if((mask2&(1<<j))==0)
                    res+=minEdge[j];
            return res;
        }
        if(dp[i][mask2]!=null) return dp[i][mask2];
        
        int mini = INTMAX;
        for(int j = 0; j<size2; j++)
        {
            mini = Math.min(mini, cost.get(i).get(j) + minCost(i+1, mask2|(1<<j)));
        }
        return dp[i][mask2] = mini;
        
    }
    public int connectTwoGroups(List<List<Integer>> costMatrix) {
        
        cost = costMatrix;
        size1 = cost.size();
        size2 = cost.get(0).size();
        dp = new Integer[size1][1<<size2];
        minEdge = new int[cost.get(0).size()];
        Arrays.fill(minEdge, INTMAX);
        buildMinEdgeCost();
        return minCost(0,0);
    }
    public void buildMinEdgeCost()
    {
        for(int j = 0; j<cost.get(0).size(); j++)
        {
            for(int i = 0;i<cost.size(); i++)
            minEdge[j] = Math.min(minEdge[j], cost.get(i).get(j));
        }
    }
}

class Minimum_Cost_to_Connect_Two_Groups_of_Points1 { // TLE APPROACH
    
    List<List<Integer>> cost;
    int size1, size2;
    int dp[][];
    public int minCost(int mask1, int mask2)
    {
        if(mask1 == (1<<size1)-1 && mask2 == (1<<size2)-1) return 0;
        if(dp[mask1][mask2]!=-1) return dp[mask1][mask2];
        
        int mini = Integer.MAX_VALUE/2;
        for(int i = 0; i<size1; i++)
        {
            
            boolean taken1 = (mask1&(1<<i))!=0;
            for(int j = 0; j<size2; j++)
            {
                boolean taken2 = (mask2&(1<<j))!=0;
                if(!taken1 || !taken2)
                    mini = Math.min(mini, cost.get(i).get(j) + minCost(mask1|(1<<i), mask2|(1<<j)));
            }
        }
        return dp[mask1][mask2] = mini;
        
    }
    public int connectTwoGroups(List<List<Integer>> costMatrix) {
        cost = costMatrix;
        size1 = cost.size();
        size2 = cost.get(0).size();
        dp = new int[1<<size1][1<<size2];
        for(int a[] : dp) Arrays.fill(a, -1);
        return minCost(0,0);
    }
}