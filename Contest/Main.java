import java.io.*;
import java.util.*;

@SuppressWarnings("all")
public class Main 
{
    static Map<Integer, Set<Integer>> edges = new HashMap<>();
    static void solve(FastReader sc)
    {
        int n = sc.nextInt(), k = sc.nextInt();
        
        int arr[] =new int[n];
        int copy[] = new int[n];
        for(int i =0; i<n; i++) {copy[i] = arr[i] = sc.nextInt()+sc.nextInt()+sc.nextInt();}
        
        sort(arr, true);
        int limit = arr[k-1];
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            al.add(copy[i]+300>=limit?"Yes":"No");
        }
        for(String s: al) sc.println(s);


        


    }
    static class DSU 
    {
        public int parent[];
        public int rank[];
        public DSU(int num)
        {
            parent = new int[num];
            rank = new int[num];
            Arrays.fill(rank,1);
            Arrays.fill(parent,-1);
        }
        public int find( int i)
        {
            if(parent[i]== -1)
            {
                return i;
            }
            return parent[i] = find(parent[i]); // Path Compression
        }
        public boolean union(int a, int b)
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
                return true;
            }
            return false;
        }
    }
    static void addNode(int n)
    {
        edges.put(n, new HashSet<>());
    }
    static void addEdge(int u, int v)
    {
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
            // int t = sc.nextInt();
            // for(int T = 1;T <=t ;T++)
            solve(sc);
            //CODE END
            sc.closer();
        }
        else
        {
            FastReader sc=new FastReader(); 
            //CODE BEGIN
            // int t = sc.nextInt();
            // for(int T = 1;T <=t ;T++)
            solve(sc);
            //CODE END
            sc.closer();

        }
    }
    static final int INTMAX = Integer.MAX_VALUE/2;
    static final int INTMIN = Integer.MIN_VALUE/2;
    static final long mod = 1000000000+7;
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
    static List<List<Integer>> perms = new ArrayList<>();
    static void generatePermutations(int[] p, int depth) {

        // To generate all permuations of 1...n, 
        // call generatePermutations(int[n] p, 1)
        // Results stored in perms
        int n = p.length;
        if (depth == n) {
            List<Integer> tmp = new ArrayList<>();
            for(int i : p)tmp.add(i);
            
            perms.add(tmp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (p[i] == 0) {
                p[i] = depth;
                generatePermutations(p, depth + 1);
                p[i] = 0;
            }
        }
    }
    static class pair implements Comparable < pair >
    {
        long x;
        long y;
        pair(long i, long j) {
            x = i;
            y = j;
        }
        public int compareTo(pair p) {
            if (this.y != p.y) {
                return Long.compare(this.y,p.y);
            } else {
                return Long.compare(this.x,p.x);
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
    static int upper_bound(int arr[], int key)
    {
        // Smallest vales greater than or equal to key
        int left = 0, right = arr.length-1;
        int pos = -1;
        while(left<=right)
        {
                int mid = left +(right-left)/2;
                if(arr[mid]>= key)
                {
                    pos = mid;
                    right = mid - 1;
                }
                else
                    left = mid + 1;
        }
        return pos;
    }
    static int lower_bound(int arr[], int key)
    {
        // Largest value less than or equal to key
        int left = 0, right = arr.length-1;
        int pos = -1;
        while(left<=right)
        {
                int mid = left +(right-left)/2;
                if(arr[mid] <= key)
                {
                    pos = mid;
                    left = mid + 1;
                }
                else
                    right = mid - 1;
        }
        return pos;
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