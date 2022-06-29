public class Odd_Even_Jump {
    Boolean dp[][];
    int n;
    TreeMap<Integer,Integer> map = new TreeMap<>();
    // dp[i][even/odd] = T/F whether it is possible to reach last cell from i by making an even jump
    //                   or odd jump. Since i<j...so we traverse from back and use a TreeMap to satisfy the conditions
    public int oddEvenJumps(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n][2];
        dp[n-1][0] = dp[n-1][1] = true;
        map.put(nums[n - 1], n - 1);
        int cnt = 1;
        for(int i = n-2; i>=0; i--)
        {
            Integer higher = map.ceilingKey(nums[i]), lower = map.floorKey(nums[i]);
            if(lower!=null)
                dp[i][0] = dp[map.get(lower)][1];
            else
                dp[i][0] = false;
            if(higher!=null)
                dp[i][1] = dp[map.get(higher)][0];
            else
                dp[i][1] = false;
            if(dp[i][1])
                cnt++;
            map.put(nums[i], i);
        }
        return cnt;
    }
}
