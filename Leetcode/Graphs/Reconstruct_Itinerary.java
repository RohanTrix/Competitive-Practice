public class Reconstruct_Itinerary
{
    // LOGIC : Problem is based on Euler Path of Directed Graph - https://youtu.be/8MpoO2zA2l4
    // CODE IDEA : Similar to this : https://leetcode.com/problems/reconstruct-itinerary/discuss/359942/Awesome-question-or-new-algo-to-learn-or-Eulerian-Path-or-Full-explanation-or-Code
    Map<String, PriorityQueue<String>> map;
    List<String> res;
    public void dfs(String node)
    {
        while(!map.getOrDefault(node, new PriorityQueue<>()).isEmpty())
        {
            String to = map.get(node).poll();
            dfs(to);
        }
        res.add(node);
        
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>(); res = new ArrayList<>();
        for(List<String> edge : tickets)
        {
            String a = edge.get(0), b = edge.get(1);
            map.computeIfAbsent(a, k-> new PriorityQueue<>()).add(b);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }
}