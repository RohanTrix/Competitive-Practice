// IDEA : Simple brute force with storing and of first two elements in a map

public class Triples_with_Bitwise_AND_Equal_To_Zero {
    public int countTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int first : nums)
            for(int second : nums)
                map.put(first & second, map.getOrDefault(first & second,0)+1);
        
        int res = 0;
        for(int third : nums)
            for(int key : map.keySet())
                if((third & key) == 0)
                    res+=map.get(key);
        return res;
    }
}
