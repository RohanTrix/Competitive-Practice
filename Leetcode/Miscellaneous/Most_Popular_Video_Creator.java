public class Most_Popular_Video_Creator {
    // IDEA : Lot of HashMaps to track different stuff
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

        Map<String, PriorityQueue<String>> map = new HashMap<>(); // Owner -> PQ of song ids
        Map<String, Map<String, Integer>> viewCnt = new HashMap<>(); // Owner -> Map of Song ID -> cnt of views for this song
        Map<String, Long> pop = new HashMap<>(); // Owner -> Popularity Count
        long maxPop = -1;
        int n = ids.length;
        for(int i = 0; i<n; i++)
        {
            String owner = creators[i];
            viewCnt.computeIfAbsent(owner, k-> new HashMap<>());
            Map<String, Integer> idToView = viewCnt.get(owner);
            idToView.put(ids[i], views[i]);
            map.computeIfAbsent(creators[i], k -> new PriorityQueue<>((a,b) -> {
                Map<String, Integer> tmp = viewCnt.get(owner);
                int v1 = tmp.get(a);
                int v2 = tmp.get(b);
                if(v1 == v2)
                    return a.compareTo(b);
                return Integer.compare(v2, v1);
            })).add(ids[i]);
            pop.put(owner, pop.getOrDefault(owner, 0L) + views[i]);
            maxPop = Math.max(maxPop, pop.get(owner));
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : pop.keySet())
        {
            if(pop.get(key) == maxPop)
            {
                List<String> tmp = List.of(key, map.get(key).peek());
                ans.add(tmp);
            }
        }
        return ans;
        
    }
}
