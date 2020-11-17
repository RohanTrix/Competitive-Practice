import java.util.*;
import  java.io.*;
public class Bipartite {
  // Adjaceny List
  public Map<Integer, Set<Integer>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  public static int color[] = new int[100000 + 1];
  public static void main(String[] args)
  {
    FastReader sc=new FastReader();
    //System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    //System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    Bipartite g = new Bipartite();
    for(int i =1; i<=n;i++)
    {
      g.addNode(i);
    }
    for(int i =0; i< m;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }
    sc.print(g.bfs(1));
    sc.closer();
  } 
  int bfs(int v)
  {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    
    Arrays.fill(color, -1);
    color[v] = 0;
    q.offerLast(v);
    while(q.size()!=0)
    {
      int s = q.pollFirst();
      // Process node s
      for( int u : edges.get(s))
      {
        if( color[u]== -1)
        {
            color[u] = 1 ^ color[s];
            q.offerLast(u); // We only add to list whenever we have find unvisited (denoted by -1)
        }
        else if( color[u] ==color[s])
            return 0;
        
      }
    }
    return 1;
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
    edges.get(v).add(u);

  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
  }
}