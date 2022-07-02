public class Maximum_Gap {
    // REFER FOR Explanation:https://youtu.be/sK-ON4570TI
    // REFER FOR CODE :https://leetcode.com/problems/maximum-gap/discuss/1241681/JavaPython-Bucket-Idea-with-Picture-Clean-and-Concise-O(N) 

    public int maximumGap(int[] nums) {
        int n = nums.length, mini = nums[0], maxi = nums[0];
        for(int num : nums)
        {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }
        if(mini == maxi) return 0;
        int bucketSize = (int)Math.ceil(1.0*(maxi - mini)/(n-1));
        int minBucket[] = new int[n];
        int maxBucket[] = new int[n];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for(int num : nums)
        {
            int currBucket = (num - mini)/bucketSize;
            minBucket[currBucket] = Math.min(minBucket[currBucket], num);
            maxBucket[currBucket] = Math.max(maxBucket[currBucket], num);
        }
        int left = 0;
        int maxGap = bucketSize;
        for(int right = 1; right<n; right++)
        {
            if(maxBucket[right]==Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[right] - maxBucket[left]);
            left = right;
        }
        return maxGap;
    }
}
