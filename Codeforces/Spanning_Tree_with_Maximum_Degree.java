package Codeforces;

import java.io.*;
import java.util.*;


@SuppressWarnings("all")
public class Spanning_Tree_with_Maximum_Degree {
    HashMap<Integer, Set<Integer>> edges = new HashMap<>();
    ArrayList<pair> res = new ArrayList<>();
    HashSet<Integer> vis = new HashSet<>();
    static class pair
    {
        int x,y;
        public pair(int xx, int yy)
        {
            x = xx;
            y =yy;
        }
        public String toString()
        {
            return x+" "+y;
        }
    }
    static void solve(FastReader sc)
    {
        Spanning_Tree_with_Maximum_Degree g = new Spanning_Tree_with_Maximum_Degree();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int indeg[] = new int[n+1];
        for(int i =0; i<m; i++)
        {
            int from = sc.nextInt(), to = sc.nextInt();
            indeg[from]++; indeg[to]++;
            g.addEdge(from, to);
        }
        int maxDeg = 0;
        int maxNode = 0;
        for(int i =1; i<=n;i++)
        {
            if(maxDeg<indeg[i])
            {
                maxDeg = indeg[i];
                maxNode = i;
            }
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(maxNode);
        g.vis.add(maxNode);
        while(!dq.isEmpty())
        {
            int node = dq.pollFirst();
            for(int v: g.edges.get(node))
            {
                if(g.vis.contains(v)) continue;
                dq.add(v);
                g.vis.add(v);
                g.res.add(new pair(node, v));
            } 
        }
        for(int i =0; i<g.res.size(); ++i)
        {
            sc.println(g.res.get(i));
        }
        
    }
    void addNode(int a)
    {
        if(!edges.containsKey(a))
            edges.put(a, new TreeSet<>());
    }
    void addEdge(int u, int v)
    {
        addNode(u);
        addNode(v);
        edges.get(u).add(v);
        edges.get(v).add(u);
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

