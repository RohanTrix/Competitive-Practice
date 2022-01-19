package Leetcode.Miscellaneous;

public class Closest_Divisors {
    public int[] closestDivisors(int num) {
        // Find pairs of pactors for num+1 and num+2 and take the best answer
        num++;
        int ans[] = new int[2];
        int diff = Integer.MAX_VALUE;
        for(int i =1; i*i<=num; i++)
        {
            if(num%i==0)
            {
                if((num/i - i)<diff)
                {
                    diff = num/i - i;
                    ans[0] = i; ans[1] = num/i;
                }
            }
        }
        
        num++;
        for(int i =1; i*i<=num; i++)
        {
            if(num%i==0)
            {
                if((num/i - i)<diff)
                {
                    diff = num/i - i;
                    ans[0] = i; ans[1] = num/i;
                }
            }
        }
        return ans;
    }
}
