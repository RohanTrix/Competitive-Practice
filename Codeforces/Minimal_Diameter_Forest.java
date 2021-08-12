package Codeforces;

import java.io.*;
import java.util.*;

@SuppressWarnings("all")

public class Minimal_Diameter_Forest 
{
    static class TreeCenter
{
    Map<Integer, Set<Integer>> currEdges = new HashMap<>();
    public int run(Set<Integer> nodes, Map<Integer, Set<Integer>> edges)
    {
    
        for(int at : nodes)
        {
            currEdges.put(at, edges.get(at));
        }
        
        
        ArrayList<Integer> res = findCenter();
        return res.get(0);
    }
    public ArrayList<Integer> findCenter()
    {
        int n = currEdges.size();
        HashMap<Integer, Integer> indeg = new HashMap<>();
        //int indeg[] = new int[n+1];
        ArrayList<Integer> leaves = new ArrayList<>();
        for(int i : currEdges.keySet())
        {
            indeg.put(i,currEdges.get(i).size()); // Setting InDegree
            if(indeg.get(i) < 2) // Single Node or Leaf Node
            {
                leaves.add(i);
                indeg.put(i,0);
            }
        }
        int count = leaves.size();
        while(count<n)
        {
            ArrayList<Integer> new_leaves = new ArrayList<>();
            for(int leaf : leaves)
            {
                for(int to : currEdges.get(leaf))
                {
                    indeg.put(to, indeg.get(to)-1);
                    
                    if(indeg.get(to)==1)
                        new_leaves.add(to);
                }
                // indeg[leaf] = 0; Line no necessary
            }
            count+=new_leaves.size();
            leaves = new ArrayList<>(new_leaves);
        }
        return leaves;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    void addNode(int u)
    {
        if(!currEdges.containsKey(u))
        currEdges.put(u, new HashSet<>());
    }
    void addEdge(int u, int v)
    {
        currEdges.get(u).add(v);
        currEdges.get(v).add(u);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
}
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    ArrayList<Integer> centers = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    Set<Integer> currNodes = new HashSet<>();
    int bestLen = -1, bestNode = -1, maxlen = -1, maxNode = -1;
    static void solve(FastReader sc)
    {
        Minimal_Diameter_Forest ob = new Minimal_Diameter_Forest();
        // GRAPH CREATION : START
        
        //System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        for(int i =1; i<=n; i++) ob.addNode(i);

        //System.out.println("Enter the number of edges: ");
        int m = sc.nextInt();
        
        for(int i = 0; i<m; i++)
        {
            ob.addEdge(sc.nextInt(), sc.nextInt());
        }
        
        // GRAPH CREATION : END
        for(int i = 1; i<=n; i++)
        {
            if(ob.visited.contains(i)==false)
                {
                    //System.out.println(i);
                    ob.maxlen = -1;
                    ob.currNodes.add(i);
                    ob.dfs(i, 1);
                    int start = ob.maxNode;
                    ob.maxlen = -1; ob.visited.clear();
                    ob.dfs(ob.maxNode, 1);
                    
                    TreeCenter o = new TreeCenter();
                    int currCentre = i;
                    //System.out.println(ob.currNodes);
                    if(ob.currNodes.size()!=1)
                        currCentre  = o.run(ob.currNodes, ob.edges);
                    ob.centers.add(currCentre);
                    //System.out.println("Currcentre: "+currCentre);
                    if(ob.bestLen <ob.maxlen)
                    {
                        ob.bestNode = currCentre;
                        ob.bestLen = ob.maxlen;
                    }
                   
                    ob.currNodes.clear();
                    
                }
        }
        ArrayList<pair> final_res = new ArrayList<>();
        for(int i =0; i<ob.centers.size(); i++)
        {
            int currCentre = ob.centers.get(i);
            if(ob.bestNode!=currCentre)
            {
                final_res.add(new pair(ob.bestNode, currCentre));
                ob.addEdge(ob.bestNode, currCentre);
            }
        }
        ob.visited.clear();
        ob.maxlen = -1;ob.maxNode = -1;
        ob.dfs(1, 1);
        ob.maxlen = -1; ob.visited.clear();
        ob.dfs(ob.maxNode, 1);
        sc.println(ob.maxlen-1);
        for(int i = 0; i<final_res.size(); i++)
        {
            sc.println(final_res.get(i));
        }

    }
    public void dfs(int node, int d)
    {
        
        if(visited.contains(node)) return;
        visited.add(node);
        currNodes.add(node);
        //System.out.println(currNodes);
        if( d > maxlen )
        {
            maxNode = node;
            maxlen = d;
        }
        for(int to : edges.get(node))
            dfs(to, d+1);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    void addNode(int u)
    {
        if(!edges.containsKey(u))
            edges.put(u, new TreeSet<>());
    }
    void addEdge(int u, int v)
    {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
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
