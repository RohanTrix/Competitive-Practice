### Q1. https://leetcode.com/problems/best-time-to-buy-and-sell-stock

---
> Idea : Keep finding the min uptil ith index...subtract it from prices[i]...update profit is better than previous
---

```java
public int maxProfit(int[] prices) {
        int maxProf = 0;
        int lastMin = Integer.MAX_VALUE/2, lastMax = Integer.MIN_VALUE/2;
        for(int i = 0; i<prices.length; i++)
        {
            lastMin = Math.min(lastMin, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - lastMin);
        }
        return maxProf;
    }
```

### Q2. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

---
Idea : 

DP[i][hold] -> Max profit at end of day i with(hold=1) and without(hold=0) holding a stock

---

```java
class Solution {
    int dp[][];
    int INTMIN = Integer.MIN_VALUE/2; 
    int prices[];
    public int getProfit(int i, int hold)
    {
        if(i==0) return (hold==0)?0:INTMIN;
        if(dp[i][hold]!=INTMIN)return dp[i][hold];
        
        // Not holding a stock
        if(hold==0)
        {
            // Choice 1
            // Profit when we didn't hold stock the previous day
            // Choice 2
            // Profit when we held stock the previous day
            // and sell it today

            // We need max of these 2 profits
            return dp[i][hold] = Math.max(getProfit(i-1,0), 
                                          getProfit(i-1,1) + prices[i-1]);
        }
        else
        {
            // Choice 1
            // Profit when we didn't hold stock the previous day
            // and bought it today
            // Choice 2
            // Profit when we held stock the previous day

            // We need max of these 2 profits
            return dp[i][hold] = Math.max(getProfit(i-1,0) - prices[i-1],
                                          getProfit(i-1,1));
        }
    }
    public int maxProfit(int[] pri) {
        int len = pri.length;
        prices = Arrays.copyOf(pri,len);
        dp = new int[len+1][2];
        for(int a[]:dp)
            Arrays.fill(a,INTMIN);
        return getProfit(len,0);// Profit on last day when no stock held(since transaction should be complete)
    }
}
```

### Q3. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
### Q4. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

---
Idea : 

---

```java
int dp[][][];
    int K;
    int INTMIN = Integer.MIN_VALUE/2; 
    int prices[];
    public int getProfit(int i, int k, int hold)
    {
        if(i==0 && hold==0)return 0;
        if(k==0 && hold==0)return 0;
        if(i==0 && hold==1)return INTMIN;
        if(k==0 && hold==1)return INTMIN;
        if(dp[i][k][hold]!=INTMIN)return dp[i][k][hold];
        
        if(hold==0)
        {
            return dp[i][k][hold]=Math.max(getProfit(i-1, k, 0), getProfit(i-1,k,1)+prices[i-1]);
        }
        else
        {
            return dp[i][k][hold]= Math.max(getProfit(i-1, k-1,0) -prices[i-1], getProfit(i-1,k,1));
        }   
    }
    public int maxProfit(int k, int[] pri) {
        K=k;
        prices = new int[pri.length];
        prices = Arrays.copyOf(pri, pri.length);
        dp = new int[prices.length+1][K+1][2];
        for(int a[][]:dp)
            for(int b[]:a)
                Arrays.fill(b,INTMIN);
        int maxi = INTMIN;
        for(int i = 0;i<=K;i++)
            maxi = Math.max(maxi, getProfit(pri.length,i,0));
        

        return maxi;
    }
```

### Q5. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
---
Idea :

Same as Q2 ...just subtract fee when buying stock

---
```java
    int dp[][];
    int INTMIN = Integer.MIN_VALUE/2; 
    int prices[];
    int fee;
    public int getProfit(int i, int hold)
    {

        if(i==0) return (hold==0)?0:INTMIN;
        
        if(dp[i][hold]!=INTMIN)return dp[i][hold];
        
        if(hold==0)
        {
            return dp[i][hold] = Math.max(getProfit(i-1,0), 
                                          getProfit(i-1,1) + prices[i-1]);
        }
        else
        {
            return dp[i][hold] = Math.max(getProfit(i-1,0) - prices[i-1]-fee,
                                          getProfit(i-1,1));
        }
    }
    public int maxProfit(int[] pri, int fees) {
        int len = pri.length;
        fee = fees;
        prices = Arrays.copyOf(pri,len);
        dp = new int[len+1][2];
        for(int a[]:dp)
            Arrays.fill(a,INTMIN);
        return getProfit(len,0);
    }
```

### Q6. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
---
Idea :


---
