package Leetcode;

class Maximum_ice_Cream_Bars {
    public int maxIceCream(int[] costs, int coins) {
        int n  =costs.length;
        Arrays.sort(costs);
        int rem = coins, c=0;
        for( int i =0;i<n; i++)
        {
            if(costs[i]<=rem)   
            {
                c++;
                rem-=costs[i];
            }
            else
                break;
        }
        return c;
        }
}