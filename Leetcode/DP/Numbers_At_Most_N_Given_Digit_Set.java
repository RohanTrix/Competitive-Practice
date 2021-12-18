class Solution {
    String digs[];
    int dp[][];
    public int count(char num[], int ind, int restrict)
    {
        // Successfully formed a number
        if(ind == num.length)return 1; 
        
        // Return dp value if stored
        if(dp[ind][restrict]!=-1)return dp[ind][restrict];
        
        int sum = 0;
        
        // If this position has restrcition on digits that can be used,
        if(restrict==1)
        {
            // Use each digit while each digit is smaller than num[ind] digit
            int i = 0;
            while(i<digs.length && digs[i].charAt(0)<=num[ind])
            {
                // If digit used is the max digit that can be used,
                // then the digit after this will be restricted
                if(digs[i].charAt(0)==num[ind])
                {
                    sum+=count(num, ind+1, 1);
                    break;
                }
                
                // If digit lower than max digit that can be used,
                // the next digit can be any of the possible digits
                sum+=count(num, ind+1, 0);
                
                i++;
            }
        }
        else
        {
            // If there is no restrictions, we can put
            // any given digit on each position of the number
            
            sum = (int)Math.pow(digs.length, num.length-ind);
        }
        return dp[ind][restrict] = sum; // Memoize
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        digs = digits;
        
        // Number converted to a character array
        char num[] = String.valueOf(n).toCharArray();
        dp  = new int[num.length][2];
        for(int[] d:dp) Arrays.fill(d, -1);
        
        int finsum = 0; // Stores final sum
        
        // Count numbers with digits less than len(num)
        for(int i =1; i<num.length; i++)
        finsum+=(int)Math.pow(digs.length, num.length-i);
        
        for(int[] d:dp) Arrays.fill(d, -1);
        finsum += count(num, 0,1); // The first digit is always restricted for D digit numbers
        
        // System.out.println(Arrays.toString(dp));
        return finsum;
    }
}