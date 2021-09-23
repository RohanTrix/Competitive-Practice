import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.stream.IntStream;
@SuppressWarnings("all")
public class Main 
{
    static void solve(FastReader sc)
    {
        int n = sc.nextInt();
        long arr[] = new long[n];
        long orsum=0;
        for(int i =0; i<n; i++){arr[i] = sc.nextLong();orsum+=arr[i];}
        long sum = orsum;
        Arrays.sort(arr);
        
        int m = sc.nextInt();
        for(int i = 0; i<m; i++)
        {
            long def = sc.nextLong(), att = sc.nextLong();
            
            int l = 0,r = n-1, pos1 = -1, pos2 = -1;
            while(l<=r)
            {
                int mid = l +(r-l)/2;
                if(arr[mid]>= def)
                {
                    pos1 = mid;
                    r = mid - 1;
                }
                else
                    l = mid+1;
            }
            long res = Long.MAX_VALUE;
            if(pos1!=-1)
            {
                long def_inc = Math.max(0L, def-arr[pos1]);
                long att_inc = Math.max(0L, att- (sum-arr[pos1]));
                res = def_inc+att_inc;
            }
            l = 0;r = n-1;
            while(l<=r)
            {
                int mid = l + (r-l)/2;
                if(arr[mid]<=def)
                {
                    pos2 = mid;
                    l = mid+1;
                }
                else
                    r = mid -1;
            }
            
            if(pos2!=-1)
            {
                long def_inc = Math.max(0L, def-arr[pos2]);
                long att_inc = Math.max(0L, att- (sum-arr[pos2]));
                res = Math.min(res, def_inc+att_inc); 
            }
            sc.println(res);
            sum = orsum;
            
        }
    }
    public static void main(String[] args) 
    {
        // FastReader(true)         for File I/O
        // FastReader()             for terminal I/O
        if(args.length>0 && args[0].equals("local")){
            FastReader sc=new FastReader(true); 
            //CODE BEGIN
            //int t = sc.nextInt();
            //for(int T = 1;T <=t ;T++)
            solve(sc);
            //CODE END
            sc.closer();
        }
        else
        {
            FastReader sc=new FastReader(); 
            //CODE BEGIN
            //int t = sc.nextInt();
            //for(int T = 1;T <=t ;T++)
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