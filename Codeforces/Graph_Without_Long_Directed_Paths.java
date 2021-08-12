package Codeforces;

import java.io.*;
import java.util.*;
 
/*
What if the given graph will contain a cycle of odd length?
 It will mean that some two consecutive edges of this cycle 
 will be oriented in the same way and will form a path of 
 length two. 
 
 What if there is no cycles of odd length in this graph? 
 Then it is bipartite. 
 Let's color it and see what we got. We got some vertices 
 in the left part, some vertices in the right part and all 
 edges connecting vertices from different parts. Now we can just 
 fix all edges with a value 0 or 1 depending whether starting node is
 color 0 or 1 (All edges go from a color 0 to a color 1... or vice versa).
*/
 
 
@SuppressWarnings("all")
public class Graph_Without_Long_Directed_Paths {
    Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
    int color[];
    void addNode(int u)
    {
        if(!edges.containsKey(u)) edges.put(u, new ArrayList<>());
    }
    void addEdge(int u, int v)
    {
        addNode(u);
        addNode(v);
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
    static void solve(FastReader sc)
    {
        
        Graph_Without_Long_Directed_Paths g = new Graph_Without_Long_Directed_Paths();
        int n = sc.nextInt();
        int m = sc.nextInt();
        g.color = new int[n+1];
        Arrays.fill(g.color, -1);
        pair edgesArr[] = new pair[m];
        for(int i =0; i<m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.addEdge(a, b);
            edgesArr[i] = new pair(a,b);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        g.color[1] = 0;
        boolean f = true;
        while(!q.isEmpty())
        {
            int u = q.pollFirst();
            for(int kid : g.edges.get(u))
            {
                if(g.color[kid] == -1)
                {
                    g.color[kid] = 1- g.color[u];
                    q.add(kid);
                }
                else if(g.color[kid]==g.color[u])
                {
                    sc.println("NO");
                    return;
 
                }
            }
        }
        StringBuilder s = new StringBuilder();
        
        for(int i = 0; i<m; i++)
        {
            int u = edgesArr[i].x;
            int v = edgesArr[i].y;
            if(g.color[u]==0)
                s.append("1");
            else
                s.append("0");
        }
        sc.println("YES");
        sc.println(s.toString());
        
        
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
    static class pair implements Comparable < pair >
    {
        int x;
        int y;
        pair(int i, int j) {
            x = i;
            y = j;
        }
        public int compareTo(pair p) {
            if (this.x != p.x) {
                return Integer.compare(this.x,p.x);
            } else {
                return Integer.compare(this.y,p.y);
            }
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
