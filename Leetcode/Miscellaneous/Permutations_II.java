public class Permutations_II {
    // REFER :https://youtu.be/qhBVWf0YafA
    List<List<Integer>> res = new ArrayList<>();
    public void permute(ConcurrentHashMap<Integer, Integer> map, List<Integer> curr)
    {
        if(map.size() == 0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        Set<Integer> set = map.keySet();
        for(int key : set)
        {
            map.put(key, map.get(key)-1);
            if(map.get(key) == 0) map.remove(key);
            curr.add(key);
            permute(map, curr);
            curr.remove(curr.size()-1);
            map.put(key, map.getOrDefault(key,0)+1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num,0)+1);
        permute(map, new ArrayList<>());
        return res;
    }
}
