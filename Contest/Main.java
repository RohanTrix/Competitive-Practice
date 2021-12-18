import java.io.*;
import java.util.*;

@SuppressWarnings("all")
public class Main 
{
    String digs[];
    int dp[][];
    public int count(char num[], int ind, int restrict)
    {
        if(ind == num.length)return 1;
        
        if(dp[ind][restrict]!=-1)return dp[ind][restrict];
        int sum = 0;
        if(restrict==1)
        {
            int i = 0;
            while(i<digs.length && digs[i].charAt(0)<=num[ind])
            {
                if(digs[i].charAt(0)==num[ind])
                {sum+=count(num, ind+1, 1);break;}
                
                sum+=count(num, ind+1, 0);
                i++;
            }
        }
        else
        {
            sum = (int)Math.pow(digs.length, num.length-ind);
        }
        System.out.println(Arrays.toString(dp));
        return dp[ind][restrict] = sum;
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        digs = digits;
        
        char num[] = String.valueOf(n).toCharArray();
        dp  = new int[num.length][2];
        
        int finsum = 0;
        for(int i =1; i<num.length; i++)
        finsum+=(int)Math.pow(digs.length, num.length-i);
        
        for(int[] d:dp) Arrays.fill(d, -1);
        finsum += count(num, 0,1);
        
        //System.out.println(Arrays.toString(dp));
        return finsum;
    }
    static void solve(FastReader sc)
    {
        String digits[] = {"7"};
        int n = 8;
        Main ob = new Main();
        sc.println(ob.atMostNGivenDigitSet(digits, n));

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