package Leetcode.Graphs;
import java.util.*;
public class Path_with_Maximum_Probability {
    public Map<Integer, Set<pair>> edges = new HashMap<>();
    public Set<Integer> visited = new HashSet<>();
    static class pair
    {
        int to; double prob;
        public pair(int u, double p)
        {
            this.to = u;
            prob = p;
        }
    }
    public double maxProbability(int n, int[][] edgeList, double[] succProb, int start, int end) {
        
        /// Make graph
        for(int i =0; i<n;i++)addNode(i);
        for(int i=0;i<edgeList.length; i++)
            addEdge(edgeList[i][0], edgeList[i][1], succProb[i]);
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.prob,a.prob));
        double bestProb[] = new double[n];
        Arrays.fill(bestProb, -1.0);
        bestProb[start] = 1.0;
        pq.add(new pair(start,1));
        
        while(!pq.isEmpty())
        {
            pair curr = pq.poll();
            visited.add(curr.to);
            if(bestProb[curr.to] > curr.prob) continue;
            
            for(pair edge : edges.get(curr.to))
            {
                if(visited.contains(edge.to))continue;
                double newProb= 1.0*bestProb[curr.to]*edge.prob;
                
                if(newProb> bestProb[edge.to])
                {
                    bestProb[edge.to] = newProb;
                    pq.add(new pair(edge.to, newProb));

                }
            }
            if(curr.to == end)return (bestProb[end]==-1.0)?0:bestProb[end];
        }
        return (bestProb[end]==-1.0)?0:bestProb[end];
    }
    
    ////////////////ADJ LIST MAKER////////////////
    public void addNode(int u)
    {
        edges.put(u, new HashSet<>());
    }
    public void addEdge(int u, int v,double w)
    {
        edges.get(u).add(new pair(v,w));
        edges.get(v).add(new pair(u,w));
    }
    //////////////////////////////////////////////
}
