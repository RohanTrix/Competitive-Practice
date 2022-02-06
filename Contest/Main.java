import java.io.*;
import java.util.*;


@SuppressWarnings("all")
public class Main 
{
    
    static Map<Integer, Set<Integer>> edges = new HashMap<>();
    static void solve(FastReader sc)
    {
        int odd = -1, even = -1;
        int n = sc.nextInt();
        int arr[] = sc.nextArray(n);
        
        for(int i = 0; i<n ; i++){
            if(arr[i]%2!=0)
            odd = i;
            else
            even = i;
        }
        if(odd==-1)
        {
            sc.println(-1);
            return;
        }
        int moves1 = 0, moves2 = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        //odd eve
        for(int i = 0; i<n; i++)
        {   
            //int b1 = (arr[i-1]&1), b2 = (arr[i]&1)
            int b = (arr[i]&1);
            if(i%2==0)
            {
                if(b==0)
                {
                    list1.add((i+1)+" "+(odd+1));
                    moves1++;
                }
            }
            else
            {
                if(b==1)
                {
                    // i, i-1
                    list1.add((i+1)+" "+(odd+1));
                    moves1++;
                }
            }
        }

       
        // eve odd
        for(int i = 0; i<n; i++)
        {   
            int b = (arr[i]&1);
            if(i%2==0)
            {
                if(b==1)
                {
                    if(odd==i)moves2 = Integer.MAX_VALUE/2;
                    else{
                        list2.add((i+1)+" "+(odd+1));
                        moves2++;
                    }
                }
            }
            else
            {
                if(b==0)
                {
                    list2.add((i+1)+" "+(odd+1));
                    moves2++;
                }
            }
        }
        if(moves1<moves2)
        {
            sc.println(moves1);
            for(String s : list1)
                sc.println(s);
        }
        else
        {
            sc.println(moves2);
            for(String s : list2)
                sc.println(s);
        }
        


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