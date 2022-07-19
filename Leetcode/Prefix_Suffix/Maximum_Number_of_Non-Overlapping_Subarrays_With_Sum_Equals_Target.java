public class Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target {
    // GREEDY AND DP BOTH SOLUTIONS

    // GREEDY
    /*
     * We maintain a running sum and a HashSet containing previous prefix sums...We can be greedy in selection
     * of prefix sum....So as soon as we find a Pj =  Pi - target....we add 1 to our cnt to denote the
     * subarray [j+1...i] and empty our prefix sum set and only add pi to set. This way, we have taken the first
     * subarray we find....and now by reseting the HashSet..we won't consider any Pj that would clash with the previous
     * subarray
     */
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int currSum = 0, cnt = 0;
        for(int num : nums)
        {
            currSum+=num;
            if(set.contains(currSum - target))
            {
                cnt++;
                set.clear();
            }
            set.add(currSum);
        }
        return cnt;
    }

    // DP
    /*
     *      IDEA : For a current prefix sum Pi, there might be several Pj such that Pj = Pi - target
     *             One subarray we have that ends at i will be from [j+1, i]. Now we need the maximum
     *             no. of subarray with sum = target ending on or before j. This is where the DP comes in.
     *             I keep a HashMap for the Pj s...and a Pj is mapped to the the dp[j] where dp[j] is the max
     *             subarray with sum=target upto j(with or without including jth).
     * 
     *             Not recommmended to follow though I was able to solve it
     */
    public int maxNonOverlapping1(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int currSum = 0;
        for(int i = 0; i<n; i++)
        {
            currSum+=nums[i];
            if(map.containsKey(currSum - target))
                dp[i] = map.get(currSum - target)+1;
            if(i!=0)
                dp[i] = Math.max(dp[i], dp[i-1]);
            map.put(currSum, Math.max(map.getOrDefault(currSum,0), dp[i]));
        }
        int maxi = 0;
        for(int num : dp)maxi = Math.max(num, maxi);
        return maxi;
    }
}
