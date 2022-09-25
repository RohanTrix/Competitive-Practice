package Leetcode.Prefix_Suffix;

// IDEA : Compute 2 arrays
//          1) Count of longest decreasing prefix length ending at i
//          2) Count fo longest decreasing suffix length ending at i
//          Use the above two to get the correct condition


public class Find_All_Good_Indices {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int decLeft[] = new int[n], decRight[] = new int[n];
        Arrays.fill(decLeft, 1); Arrays.fill(decRight, 1);
        for(int i = 1; i<n; i++)
            if(nums[i]<=nums[i-1])
                decLeft[i] = decLeft[i-1]+1;
        
        for(int i = n-2; i>=0; i--)
            if(nums[i]<=nums[i+1])
                decRight[i] = decRight[i+1]+1;
        
        List<Integer> ans = new ArrayList<>();
        for(int i = k; i<n-k; i++)
            if(decLeft[i-1] >=k && decRight[i+1]>=k)
                ans.add(i);
        return ans;
    }
}
