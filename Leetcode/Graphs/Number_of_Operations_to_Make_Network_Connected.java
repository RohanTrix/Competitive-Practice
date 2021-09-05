
/*
    Idea :  We need to use DSU. If during a union of two nodes, they are already in same set,
            then we can increase an `extra` counter. `extra` denotes the number of extra connections we have.
            Next, we find the number of connected components(from parent array). 
            To join n componenets, we need n-1 extra edges. So we check if it is possible 
            and return the answer. 
*/
import java.util.*;
public class Number_of_Operations_to_Make_Network_Connected {
    int parent[], rank[];
    int extra = 0;
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);
        for(int edge[] : connections)
        {
            union(edge[0],edge[1]);
        }
        int comps = 0;
        for(int i : parent)
            comps+=(i==-1)?1:0;
        //System.out.println(comps+" "+extra);
        if((comps-1)>extra)return -1; 
        return comps-1;
    }
    int find(int u)
    {
        if(parent[u] ==-1) return u;
        return parent[u] = find(parent[u]);
    }
    void union(int u, int v)
    {
        int s1 = find(u);
        int s2 = find(v);
        
        if(s1!=s2)
        {
            if(rank[s1]<rank[s2])
            {
                parent[s1] = s2;
                rank[s2]+=rank[s1];
            }
            else
            {
                parent[s2] = s1;
                rank[s1]+=rank[s2];
            }
        }
        else
            extra++;
    }
}
