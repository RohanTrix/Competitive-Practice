public class Least_Number_of_Unique_Integers_after_K_Removals {
    // The best(greedy) way to do it is....removing the num with the smallest freq as long as we can
    // 1 22 333 4444 

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
       
        // Building freq map of array
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i,0) + 1);
        
        // Adding key value pair to map(you don't really need the key but added anyways)
        List<pair> list = new ArrayList<>();
        for(int key : map.keySet())
            list.add(new pair(key, map.get(key)));
        Collections.sort(list); // Sorting based on smaller value
        
        int cnt = list.size(); // Current unique keys
        for(pair p : list)
        {
            int curr = p.val; 
            if(curr <=k) // Checking if we can completely remove all occurences of the curr key, if yes do it
            {
                k-=curr;
                cnt--; // No. of keys decrease by one
            }
        }
        return cnt;
        
    }
    private class pair implements Comparable<pair>
    {
        int key, val;
        public pair(int k, int v)
        {
            key = k; val = v;
        }
        public int compareTo(pair that)
        {
            return this.val - that.val;
        }
    }
}
