public class Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int num : nums)
        {
            int copy = num;
            int s = 0;
            while(copy>0)
            {
                int d = copy%10;
                s+=d;
                copy/=10;
            }
            map.computeIfAbsent(s, k-> new ArrayList<>()).add(num);
        }
        int maxi = -1;
        for(int key : map.keySet())
        {
            if(map.get(key).size()>1)
            {
                Collections.sort(map.get(key), Collections.reverseOrder());
                List<Integer> tmp = map.get(key);
                maxi = Math.max(maxi, tmp.get(0)+tmp.get(1));
            }
        }
        return maxi;
    }
}
