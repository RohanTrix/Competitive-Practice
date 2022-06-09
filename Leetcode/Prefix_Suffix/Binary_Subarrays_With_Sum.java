
class Binary_Subarrays_With_Sum
{
    //REFER: https://youtu.be/20v8zSo2v18
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        hm.put(0,1);
        int pref = 0, cnt = 0;
        for(int i =0; i<n; i++)
        {
            pref+=nums[i];
            if(hm.containsKey(pref-goal))
            {
                cnt+=hm.get(pref-goal);
            }
            hm.put(pref, hm.getOrDefault(pref,0)+1);
        }
        return cnt;
    }
}
