import java.io.*;
import java.util.*;

import javax.swing.event.InternalFrameAdapter;

@SuppressWarnings("all")
public class Main 
{
    
    static Map<Integer, Set<Integer>> edges = new HashMap<>();
    static void solve(FastReader sc)
    {
        
        int n = sc.nextInt();
        char s[] = sc.nextLine().toCharArray();
        if(s.length%2!=0)
        {
            sc.println("NO");
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<n; i++)
        {
            map.put(s[i], map.getOrDefault(s[i], 0)+1);
        }
        int maxi = 0;
        char key = '\0';
        for(char k : map.keySet())
        {
            maxi = Math.max(map.get(k), maxi);
        }
        if(maxi>s.length/2)
        {
            sc.println("NO");return;
        }
        Arrays.sort(s);

        sc.println("YES");
        for(int i =0; i<s.length/2; i++)
            sc.print(s[i]);
        for(int i = s.length-1; i>=n/2; i--)
            sc.print(s[i]);
        sc.println();


    }
    // static void addEdge(int u)
    // {
    //     if(!edges.containsKey(u))
    //         edges.add(u, new HashSet<>());
    // }
    // static void addNode(int u, int v)
    // {
        
    // }
    public static void main(String[] args) 
    {
        // FastReader(true)         for File I/O
        // FastReader()             for terminal I/O
        if(args.length>0 && args[0].equals("local")){
            FastReader sc=new FastReader(true); 
            //CODE BEGIN
            int t = sc.nextInt();
            for(int T = 1;T <=t ;T++)
            solve(sc);
            //CODE END
            sc.closer();
        }
        else
        {
            FastReader sc=new FastReader(); 
            //CODE BEGIN
            int t = sc.nextInt();
            for(int T = 1;T <=t ;T++)
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
    static class pair implements Comparable < pair >
    {
        long x;
        long y;
        pair(long i, long j) {
            x = i;
            y = j;
        }
        public int compareTo(pair p) {
            if (this.x != p.x) {
                return Long.compare(this.x,p.x);
            } else {
                return Long.compare(this.y,p.y);
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
        long[] nextArray(int n)
        {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
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