public class Fruit_Into_Baskets {
    // IDEA : Longest Subarray with only 2 types of values...normal sliding window approach
    public int totalFruit(int[] fruits) {
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        int maxi = 0;
        for(int right = 0; right<n; right++)
        {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
            while(left<right && map.size()>2)
            {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) 
                    map.remove(fruits[left]);
                left++;
            }
            maxi = Math.max(right-left+1, maxi);
        }
        return maxi;
    }
}
