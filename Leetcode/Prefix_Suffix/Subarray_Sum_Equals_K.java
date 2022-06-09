public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        hm.put(0,1);
        int pref = 0, cnt = 0;
        for(int i =0; i<n; i++)
        {
            pref+=nums[i];
            if(hm.containsKey(pref-k))
            {
                cnt+=hm.get(pref-k);
            }
            hm.put(pref, hm.getOrDefault(pref,0)+1);
        }
        return cnt;
    }
}
