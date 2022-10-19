public class Top_K_Frequent_Words {
    // SOLVED USING MIN HEAP
    // FOR OTHER APPROACHES, REFER :
    // https://leetcode.com/problems/top-k-frequent-words/discuss/431008/Summary-of-all-the-methods-you-can-imagine-of-this-problem 
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String w : words)
            map.put(w, map.getOrDefault(w, 0)+1);
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new MyComp());
        for(Map.Entry<String, Integer> e : map.entrySet())
        {
            pq.offer(e);
            if(pq.size()>k)
                pq.poll();
        }
        List<String> list = new ArrayList<>();
        // WE WILL GET HIGHEST K ELEMENTS IN ASCENDING ORDER
        while(!pq.isEmpty())
            list.add(pq.poll().getKey());
        Collections.reverse(list);
        return list;
    }
    class MyComp implements Comparator<Map.Entry<String, Integer>>
    {
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)
        {
            String word1 = e1.getKey();
            int freq1 = e1.getValue();
            String word2 = e2.getKey();
            int freq2 = e2.getValue();
            if(freq1!=freq2){
                return freq1-freq2;
            }
            else {
                return word2.compareTo(word1);
            }
        }
    }
}
