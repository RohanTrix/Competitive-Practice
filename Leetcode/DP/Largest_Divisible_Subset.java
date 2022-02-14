/*
        IDEA : The fact that this is a DP problem was tough to build intuition for. After sorting
                and seeing that no. of factors in array upto an element i (also factors of i)
                are just the number of factors of some pervious factor of i.

                This basically means we can increase factor length just like LIS problem in which we extend
                the length of the sequence. Moreover, since we need to find any subset which
                has maximum factor length, we can do it smartly by storing the index of the previous factor
                with which it can form largest subset.

                Finally, from any position with the largest SubSet size in its dp answer, we can iteratively 
                jumo back and add all the elements to a list and return it.

                // DP STATE: DP[i][0] = Max Size of Subset that cna be formed with factors of ith element before it
                             DP[i][1] = Index of the last element from which we extended our subset size
*/

public class Largest_Divisible_Subset
{
    int dp[][];
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        dp = new int[nums.length][2];
        for(int a[] : dp) a[0] = 1;
        int maxSubsetSize = 1;
        for(int i = 0; i<n; i++)
        {
            dp[i][1] = i;
            for(int j = 0; j<i; j++)
            {
                if(nums[i] % nums[j] == 0)
                {
                    if(dp[j][0] + 1 >dp[i][0])
                    {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = j;
                    }
                }
            }
            maxSubsetSize = Math.max(maxSubsetSize, dp[i][0]);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i =0; i<nums.length; i++)
        {
            if(dp[i][0] == maxSubsetSize)
            {
                ans.add(nums[i]);
                while(dp[i][1] !=i)
                {
                    i = dp[i][1];
                    ans.add(nums[i]);
                }
                return ans;
            }
        }
        return ans;
    }
}