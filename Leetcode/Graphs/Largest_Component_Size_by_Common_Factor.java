/*
    IDEA : We need to find the largest component size, hence DSU is definetly needed.
           But considering each pair of nodes and then finding gcd to decide whether to union them
           or not, we go O(n2 log(max)). 

           It is rather better to find prime factorization of each number in O(n sqrt(n)).
           We can create a map, mapping prime factor -> list of numbers from given array of which this
           is a prime factor.

           Thus, we can now just traverse each prime factor, and union all elements in its corresponding list.
           We will be at max traversing O(n sqrt(n)) times keeping us within the limits.


           Now, since we are prime factorizing for each number in the arr, its best to use 
           SPF to prime factorize. This will make premcomp = (n log (log n))
           and factorization will take (n log(n))

           Use pre computation of spf[]

*/


import java.util.stream.*;
public class Largest_Component_Size_by_Common_Factor
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
        public int find(int s)
        {
            if(parent[s]==-1) return s;
            return parent[s]=find(parent[s]);
        }
        public void union(int u, int v)
        {
            int s1 = find(u);
            int s2 = find(v);
            if(s1==s2)return;
            if(s1>s2)
            {
                parent[s2]=s1;
                rank[s1]+=rank[s2];
            }
            else
            {
                parent[s1] = s2;
                rank[s2]+=rank[s1];
            }
        }
    }
    
    public int[] generateSPF(int n) {
    int[] spf = new int[n + 1];
    Arrays.fill(spf, 2, n + 1, -1);
    for (int i = 2; i*i<= n; i++)
      if(spf[i] == -1)
      {
        spf[i] = i;
        for (int j = i * i; j <= n; j += i)
          if(spf[j] == -1) spf[j] = i;
      }
    for(int i = 2; i <= n; i++)
        if(spf[i] == -1) spf[i] = i;
    return spf;
  }
    public int largestComponentSize(int[] nums) {
        int maxi = IntStream.of(nums).max().getAsInt();
        int spf[] = generateSPF(maxi);
        DSU d = new DSU(maxi+1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int num : nums)
        {
            int copy = num;
            while(num>1)
            {
                int prime = spf[num];
                List<Integer> multiples = map.getOrDefault(prime, new ArrayList<>());
                multiples.add(copy);
                map.put(prime, multiples);
                
                while(num>1 && num%prime == 0)
                    num/=prime;
            }
        }
        //System.out.println(map);
        for(int key : map.keySet())
        {
            int leader = map.get(key).get(0);
            for(int val : map.get(key))
                d.union(leader, val);
        }
        return IntStream.of(d.rank).max().getAsInt();
    }
}

// O(n sqrt(n)) logic
import java.util.stream.*;
public class Largest_Component_Size_by_Common_Factor
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
        public int find(int s)
        {
            if(parent[s]==-1) return s;
            return parent[s]=find(parent[s]);
        }
        public void union(int u, int v)
        {
            int s1 = find(u);
            int s2 = find(v);
            if(s1==s2)return;
            if(s1>s2)
            {
                parent[s2]=s1;
                rank[s1]+=rank[s2];
            }
            else
            {
                parent[s1] = s2;
                rank[s2]+=rank[s1];
            }
        }
    }
    public int largestComponentSize(int[] nums) {
        int maxi = IntStream.of(nums).max().getAsInt();
        DSU d = new DSU(maxi+1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int num : nums)
        {
            int copy = num;
            for(int i = 2; i*i<=num; i++)
            {
                if(num%i == 0)
                {
                    while(num%i==0)
                        num/=i;
                    List<Integer> multiples = map.getOrDefault(i, new ArrayList<>());
                    multiples.add(copy);
                    map.put(i, multiples);
                }
            }
            if(num>1)
            {
                List<Integer> multiples = map.getOrDefault(num, new ArrayList<>());
                multiples.add(copy);
                map.put(num, multiples);
            }
        }

        for(int key : map.keySet())
        {
            int leader = map.get(key).get(0);
            for(int val : map.get(key))
                d.union(leader, val);
        }
        return IntStream.of(d.rank).max().getAsInt();
    }
}