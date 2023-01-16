package Leetcode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *      IDEA : Use a DSU on the accounts array to check which accounts are interconnected. To check if there
 *             is a common mail b/w 2 accounts...add the mails of one account to a set....then traverse the other account.
 *             If any mail is present in set, then its a common account. Rest is just implementation to build the answer
 * 
 */

public class Accounts_Merge {
    private class DSU
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU d = new DSU(n);
        Set<String> mails = new HashSet<>();
        for(int i = 0; i<n; i++)
            for(int j = 0; j<i; j++)
            {
                List<String> acc1 = accounts.get(i);
                List<String> acc2 = accounts.get(j);
                
                mails.clear();
                for(int k = 0; k<acc1.size(); k++)
                {
                    if(k == 0) continue;
                    mails.add(acc1.get(k));
                }
                for(int k = 0; k<acc2.size(); k++)
                {
                    if(k == 0) continue;
                    if(mails.contains(acc2.get(k)))
                    {
                        d.union(i,j);
                        break;
                    }
                }
            }
        Map<Integer, TreeSet<String>> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            int leader = d.find(i);
            TreeSet<String> currSet = map.getOrDefault(leader, new TreeSet<>());
            List<String> list = accounts.get(i);
            for(int j = 0; j<list.size(); j++)
            {
                if(j == 0) continue;
                currSet.add(list.get(j));
            }
            map.put(leader, currSet);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            if(d.parent[i] == -1)
            {
                List<String> tmp = new ArrayList<>();
                tmp.add(accounts.get(i).get(0));
                tmp.addAll(map.get(i));
                ans.add(tmp);
            }
        }
        return ans;
    }
}
