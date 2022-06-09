public class Subarray_Sums_Divisible_by_K {
    // REFER : https://youtu.be/QM0klnvTQzk
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            nums[i]%=k;
            if(nums[i]<0)nums[i]+=k;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int currSum = 0, cnt = 0;
        for(int i = 0; i<n; i++)
        {
            currSum+=nums[i];
            currSum%=k;
            cnt+=map.getOrDefault(currSum,0);
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return cnt;
    }
}
