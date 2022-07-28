/* 

    IDEA : Solved in One Go :)

           Intuition was that, since we want to check if both Alice and Bob can reach all nodes and we want to remove
           maximum no. of edges(meaning keep minimum no. of edges). So this calls for a Minimum Spanning Tree.
           But the edges are unweighted, so we don't need to be greedy in our selection of edges. Next,
           But we can use the DSU part to check whether all nodes are connected or not.
           Now some edges which are only for Alice will never be a part of Bob. And moreover, it may be possible
           that Alice's path is reachable to all nodes but Bob's isnt.

           Lets call edges as 2 kinds : Exclusive and Common.
           This helped me think of making 2 seperate graphs for Alice and Bob where each will have their own 
           separate graphs with edges exclusive to them and the common ones too. But we will not actually implement
           a graph and rather process them on the fly using 2 DSUs.

           Now, its obvious that first we would wanna take as many common edges are required. This is becuase, the
           Common edge will connect in both DSU unlike a Exclusive edge which can connect only in one.

           After connecting common edges(as many are required, meaning removing edge if 2 nodes are already connected),
           we will now process only the exclusive edges. 

           Main Idea is to increase cnt of removed edges when 2 nodes are already connected and edge is about to
           connect them and otherwise add them to DSU.

           Finally, it may be possible that Alice or Bob  or both cannot reach/ connect all nodes. For this, we will have to
           return -1. This can be easily checked using the rank of the DSU. If the rank of any node is equal to n
           in BOTH Alice and Bob's DSU, then we can return a cnt as answer, otherwise -1.

*/

public class Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable
{
    static class DSU
    {
        int parent[], rank[];
        public DSU(int n)
        {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }
        public int find(int u)
        {
            if(parent[u] == -1) return u;
            return parent[u] = find(parent[u]);
        }
        public boolean isCon(int u, int v)
        {
            return find(u) == find(v);
        }
        public void union(int u, int v)
        {
            int s1 = find(u);
            int s2 = find(v);
            if(s1!=s2)
            {
                if(rank[s1]>rank[s2])
                {
                    rank[s1]+=rank[s2];
                    parent[s2] = s1;
                }
                else
                {
                    rank[s2]+=rank[s1];
                    parent[s1] = s2;
                }
            }
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int cnt = 0; // Count of edges to remove
        DSU alice = new DSU(n+1);
        DSU bob = new DSU(n+1);
        for(int edge[] : edges) // Only processing type 3 edges
        {
            if(edge[0] == 3)
            {
                // If both nodes connected in both DSUs, then remove the edge
                if(alice.isCon(edge[1], edge[2]) && bob.isCon(edge[1], edge[2]))
                    cnt++;
                else // Else add common edge to both graphs
                {
                    alice.union(edge[1], edge[2]);
                    bob.union(edge[1], edge[2]);
                }
            }
        }
        for(int edge[] : edges) // Similar way processing Exclusive Edges
        {
            if(edge[0] == 1)
            {
                if(alice.isCon(edge[1], edge[2])) 
                    cnt++;
                else 
                    alice.union(edge[1], edge[2]);
            }
            else if(edge[0] == 2)
            {
                if(bob.isCon(edge[1], edge[2]))
                    cnt++;
                else
                    bob.union(edge[1], edge[2]);
            }
        }
        
        boolean ans1 = false, ans2 = false; // Both should be true. Meaning n nodes in a rank
        for(int i = 0; i<=n; i++)
        {
            if(alice.rank[i] == n) ans1 = true;
            if(bob.rank[i] == n) ans2 = true;
        }
        return (ans1&&ans2)?cnt:-1;
        
    }
}