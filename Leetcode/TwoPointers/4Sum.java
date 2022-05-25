package Leetcode.TwoPointers;


// REFER : https://leetcode.com/problems/4sum/discuss/1341213/C%2B%2BPython-2-solutions-Clean-and-Concise-Follow-up%3A-K-Sum
public class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i =0 ; i<n; i++)
        {
            for(int j = i+1; j<n;j++)
            {
                int p = j+1, q = n-1;
                while(p<q)
                {
                    if(nums[i]+nums[j]+nums[p]+nums[q] == target)
                    {
                        res.add(new ArrayList<Integer>(List.of(nums[i],nums[j],nums[p],nums[q])));
                        ++p; --q;
                        while (p < q && nums[p-1] == nums[p]) p++;
                    }
                    else if(nums[i]+nums[j]+nums[p]+nums[q] > target)
                        q--;
                    else
                        p++;
                }
                while (j+1 < n && nums[j] == nums[j+1]) ++j;
            }
            while (i+1 < n && nums[i] == nums[i+1]) ++i;
        }
        return res;
    }
}
