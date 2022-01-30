import java.io.*;
import java.util.*;

@SuppressWarnings("all")
public class Main 
{
    static int arr[];
    static int tree[] = new int[400400];
    static void solve(FastReader sc)
    {
        int n = sc.nextInt(), k = sc.nextInt();
        arr = sc.nextArray(n);
        buildTree(1, 0, n-1);
        for(int i = 0; i<k; i++)
        {
            if(sc.next().charAt(0)=='C')
            {
                int ind = sc.nextInt()-1;
                int val = sc.nextInt();
                // System.out.println("C: "+ind+" "+val);
                update(1, 0, n-1, ind, val);
            }
            else
            {
                int lq = sc.nextInt()-1, rq = sc.nextInt()-1;
                // System.out.println("P: "+lq+" "+rq);
                int val = query(1, 0, n-1, lq, rq);
                if(val==0)
                    sc.print(0);
                else
                    sc.print(val>0?"+":"-");
            }
        }
        sc.println();
        
    }
    static int query(int index, int l, int r, int lquery, int rquery)
    {
        if(l>rquery || lquery > r) 
            return 1;
        if(lquery<=l && r<=rquery)
            return tree[index];
        
        int mid = (l+r)/2;
        int leftAns = query(2*index, l, mid, lquery, rquery);
        int rightAns = query(2*index+1, mid+1, r, lquery, rquery);
        return leftAns*rightAns;
    }
    static void update(int index, int l, int r, int pos, int val)
    {
        /* 
         * @param index Index of the current node in Tree
         * @param l     Left boundary current node represents
         * @param r     Right boundary current node represents
         * @param pos   Index of val in actual array
         * @param val   Value to be replaced at pos position
         */
        if(pos<l || pos>r) return;
        if(l == r)
        {
            tree[index] = (int)Math.signum(val);
            return;
        }
        
        int mid = (l+r)/2;
        update(2*index, l, mid, pos, val);
        update(2*index+1, mid + 1, r, pos, val);
        tree[index] = tree[2*index] * tree[2*index + 1];
    }
    static void buildTree(int index, int l, int r){

        /* 
         * @param index Index of the current node in Tree
         * @param l     Left boundary current node represents
         * @param r     Right boundary current node represents
         */

        if(l == r)
        {
            tree[index] = (int)Math.signum(arr[l]);
            return;
        }
        int mid = (l+r)/2;
        buildTree(2*index, l, mid);
        buildTree(2*index+1, mid + 1, r);
        tree[index] = tree[2*index] * tree[2*index + 1];
    }
    public static void main(String[] args) 
    {
        // FastReader(true)         for File I/O
        // FastReader()             for terminal I/O
        if(args.length>0 && args[0].equals("local")){
            FastReader sc=new FastReader(true); 
            //CODE BEGIN
            
            //for(int T = sc.nextInt();T>0 ;T--)
            while(sc.hasNext())
            solve(sc);
            //CODE END
            sc.closer();
        }
        else
        {
            FastReader sc=new FastReader(); 
            //CODE BEGIN
            
            //for(int T = sc.nextInt();T>0 ;T--)
            while(sc.hasNext())
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
        boolean hasNext()
        {
            try{
                return br.ready();
            }
            catch(Exception e)
            {}
            return true;
        }
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch(IOException  e) 
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