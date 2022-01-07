import java.io.*;
import java.util.*;

/* IDEA:
    Brute Force with DSU. Find DSU of both the forests initially.
    Then check  for each pair of nodes from [1,n], if they belong in the same set
    in either of the graphs, we cannot add an edge. Else, 
    we save that edge and union the two nodes in both the DSUs.
*/


@SuppressWarnings("all")
public class Mocha_and_Diana_Easy 
{
    HashSet<Integer> vis = new HashSet<>();
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    static void solve(FastReader sc)
    {
        int n = sc.nextInt(), m1 = sc.nextInt(), m2 = sc.nextInt();
        Mocha_and_Diana_Easy g1 = new Mocha_and_Diana_Easy(); DSU dsu1 = new DSU(n);
        Mocha_and_Diana_Easy g2 = new Mocha_and_Diana_Easy(); DSU dsu2 = new DSU(n);
        ArrayList<pair> res = new ArrayList<>();
        for(int i = 1; i<=n;i++)
        {
            g1.addNode(i);g2.addNode(i);
        }
        for(int i = 0; i<m1; i++)
        {
            int u =  sc.nextInt();
            int v =sc.nextInt();
            g1.addEdge(u, v);
        }
        for(int i = 0; i<m2; i++)
        {
            int u =  sc.nextInt();
            int v =sc.nextInt();
            g2.addEdge(u, v);
        }
        //int cnt1 = 0, cnt2 = 0;
        for(int i =1; i<=n; i++)
        {
            if(!g1.vis.contains(i))
                {g1.dfs(i, dsu1);}
            if(!g2.vis.contains(i))
                {g2.dfs(i, dsu2);}
        }
        for(int i =1; i<=n; i++)
        {
            for(int j = 1; j<=n; j++)
            {
                if(i==j)continue;
                if(dsu1.find(i)==dsu1.find(j) || dsu2.find(i)==dsu2.find(j))
                    continue;
                
                dsu1.union(i, j);  dsu2.union(i, j);
                res.add(new pair(i,j));
            }
        }
        sc.println(res.size());
        for(int i =0; i<res.size(); i++)
        {
            sc.println(res.get(i));
        }

    }
    void dfs(int u, DSU d)
    {
        if(vis.contains(u))return;
        vis.add(u);
        for(int v : edges.get(u))
        {
            d.union(u, v);
            dfs(u,d);
        }
    }
    void addNode(int u)
    {
        if(!edges.containsKey(u))
            edges.put(u, new HashSet<>());
    }
    void addEdge(int u, int v)
    {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }

  
    static class DSU 
    {
    public int parent[];
    public int rank[];
    public DSU(int num)
    {
        parent = new int[num+1];
        rank = new int[num+1];
        Arrays.fill(rank,1);
        Arrays.fill(parent,-1);
    }
    public int find(int i)
    {
        if(parent[i]== -1)
        {
            return i;
        }
        return parent[i] = find(parent[i]); // Path Compression
    }
    public void union(int a, int b)
    {
        int s1 = find(a);
        int s2 = find(b);
        if( s1!= s2)
        {
            if( rank[s1] < rank[s2] )
            {
                parent[s1] = s2;
                rank[s2] += rank[s1];
            }
            else
            {
                parent[s2] = s1;
                rank[s1] += rank[s2]; 
            }
        }
    }
    }
    public static void main(String[] args) 
    {
        // FastReader(true)         for File I/O
        // FastReader()             for terminal I/O
        if(args.length>0 && args[0].equals("local")){
            FastReader sc=new FastReader(true); 
            //CODE BEGIN
            //for(int T = sc.nextInt();T > 0;T--)
            solve(sc);
            //CODE END
            sc.closer();
        }
        else
        {
            FastReader sc=new FastReader(); 
            //CODE BEGIN
            //for(int T = sc.nextInt();T > 0;T--)
            solve(sc);
            //CODE END
            sc.closer();

        }
    }
    public static long power(long x, long y, long mod)
    {
        long res = 1L;
        x = x%mod;
        while(y > 0)
        {
            if((y&1)==1)
                res = (res*x)%mod;
            
            y>>=1;
            x = (x*x)%mod;
        }
        return res;
    }
    public static int gcd(int a, int b)
	{
		if(b == 0)
		 return a;
		else
		return gcd(b,a%b);
    }
    public static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
    static void sort(int[] a, boolean... rev) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		if(rev.length>0 && rev[0]==true) Collections.sort(l, Collections.reverseOrder());
        else Collections.sort(l);

		for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static void fill2D(int arr[][], int n)
    {
        for (int[] row: arr)
            Arrays.fill(row, n);
    }
    static class pair
    {
        int x;
        int y;
        pair(int i, int j) {
            x = i;
            y = j;
        }
        
        public String toString() {
            return x + " " + y;
        }
        public boolean equals(Object o) {
            pair x = (pair) o;
            return (x.x == this.x && x.y == this.y);
        }
        }
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st;
        PrintWriter pw;
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in));
            pw = new PrintWriter(new OutputStreamWriter(System.out));
        }
        public FastReader(boolean b)
        {
            try
            {
                br = new BufferedReader( new FileReader("input.txt")); 
                pw = new PrintWriter("output.txt");
            
            }
            catch(Exception e)
            {

            }

        }
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken();
        } 
        int[] nextArray(int n)
        {
            int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
        }
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        }
        void print(Object...objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    pw.print(' ');
            pw.print(objects[i]);
            }
        }
        void println(Object...objects)
        {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    pw.print(' ');
            pw.print(objects[i]);
            }
            pw.println();
        }
        void viewArray1D(int a[])
        {
            println(Arrays.toString(a));
        }
        void viewArray2D(int arr[][])
        {
            for (int[] row: arr)
            viewArray1D(row);
        }
        void closer()
        {
            try{
            br.close();
            pw.flush();
            pw.close();
            }
            catch(Exception e)
            {
            }
        }
    }
}