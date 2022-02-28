public class Evaluate_Division {
    public Map<String, List<pair>> map = new HashMap<>();
    public Set<String> vis = new HashSet<>();
    double ans = -1.0;
    public void dfs(String u, String target, double tot)
    {
        if(vis.contains(u)) return;
        vis.add(u);
        if(u.equals(target))
        {
            ans = tot;
            return;
        }
        for(pair nei : map.get(u))
            dfs(nei.node, target, tot*nei.weight);
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        for(int i = 0; i<equations.size(); i++)
        {
            String node1 = equations.get(i).get(0);
            String node2 = equations.get(i).get(1);
            
            addEdge(node1, node2, values[i]);
        }
        double res[] = new double[queries.size()];
        for(int i = 0; i<queries.size(); i++)
        {
            ans = -1.0;
            String node1 = queries.get(i).get(0);
            String node2 = queries.get(i).get(1);
            if(map.containsKey(node1) && map.containsKey(node2))
                dfs(node1, node2, 1.0);
            vis.clear();
            res[i] = ans;
        }
        return res;
    }
    public void addNode(String u)
    {
        if(!map.containsKey(u)) map.put(u, new ArrayList<>());  
    }
    public void addEdge(String u, String v, double w)
    {
        addNode(u);
        addNode(v);
        map.get(u).add(new pair(v, w));
        map.get(v).add(new pair(u, 1.0/w));
    }
    static class pair
    {
        String node;
        double weight;
        public pair(String s, double w)
        {
            node = s;
            weight = w;
        }
        public String toString()
        {
            return node+" "+weight;
        }
    }
}
