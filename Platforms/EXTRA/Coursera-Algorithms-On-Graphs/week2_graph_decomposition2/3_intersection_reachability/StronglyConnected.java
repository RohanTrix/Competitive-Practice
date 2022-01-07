import java.util.*;
import java.io.*;
public class StronglyConnected {
  // Adjaceny List
  public Map<Integer, Set<Integer>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  public static List<Integer> stack = new ArrayList<>();
  public static void main(String[] args)
  {
    FastReader sc=new FastReader();
    //System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    //System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    StronglyConnected g = new StronglyConnected();
    StronglyConnected rev_g = new StronglyConnected();
    for(int i =1; i<=n;i++)
    {
      g.addNode(i);
      rev_g.addNode(i);
    }
    for(int i =0; i< m;i++)
    {
        int a = sc.nextInt(); int b = sc.nextInt();
      g.addEdge(a, b);
      rev_g.addEdge(b, a);
    }
    // FIRST-PASS
    for(int i =1; i<=n;i++)
    {
        if(!visited.contains(i))
            g.dfs(i);
    }
    // SECOND-PASS....now operate on reverse graph
    visited.clear();
    int i=0,cnt=0;
    while(stack.size()!=0)
    {
        i = stack.remove(stack.size()-1);
        if(!visited.contains(i)){
            rev_g.dfs2(i);
            cnt+=1;
        }
    }
    sc.print(cnt);
    sc.closer();
  }
  void dfs(int v) // DFS for first pass- Similar for Topological Sorting
  {
    if(visited.contains(v))
        return;
    visited.add(v);
    for(int u : edges.get(v))
        {
            dfs(u);
        }
    stack.add(v);
  }
  void dfs2(int v) // DFS ON Reverse Graph with popping of elemts from stack
  {
    if(visited.contains(v))
    {
        stack.remove(stack.size()-1);
        return;
    }
    visited.add(v);
    for(int u : edges.get(v))
        {
            dfs(u);
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
  public void addNode(int u) {
    if (!edges.containsKey(u)) {
      edges.put(u, new TreeSet<Integer>());
    }
  }
  public void removeNode(int u) {
    if (!edges.containsKey(u)) {
      return;
    }
    for (int v : edges.get(u)) {
      edges.get(v).remove(u);
    }
    edges.remove(u);
  }
  public void addEdge(int u, int v) {
    edges.get(u).add(v);
  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
  }
}