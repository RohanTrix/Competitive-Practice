package Leetcode.Graphs;

import java.util.stream.*;
import java.util.*;
public class Array_Nesting {
    int parent[];
    int rank[];
    public int arrayNesting(int[] nums) {
        
        // Initialization of DSU
        parent = new int[nums.length];
        rank = new int[nums.length];
        Arrays.fill(parent,-1);
        Arrays.fill(rank,1);
        // Init Over
        
        for(int i =0; i<nums.length; i++)
        {
            union(i,nums[i]);
        }
        return IntStream.of(rank).max().getAsInt();
        
    }
    public int find(int i)
    {
        if(parent[i]==-1)return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int u, int v)
    {
        int s1 = find(u);
        int s2 = find(v);
        if(s1!=s2)
        {
            if(rank[s1] < rank[s2])
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
    }
}