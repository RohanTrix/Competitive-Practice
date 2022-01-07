package Codechef;

import java.io.*;
import java.util.*;
public class HXOR
{
    static int leftSetBit(int n)
    {
        n |= n >> 1; 
 
        n |= n >> 2; 
  
        n |= n >> 4; 
        n |= n >> 8; 
        n |= n >> 16; 
        n = n + 1; 
        return (n >> 1); 
    }
    static void solve(FastReader sc)
    {
        int n = sc.nextInt(); int x = sc.nextInt();
        //int bitset[][] = new int[30+1][n+1];
        int arr[] = new int[n+1];
        for(int j=1;j<=n;j++)
        {
            arr[j] = sc.nextInt();
        }
        int pos=0;
        for(int i=1;i<=n-1;i++)
        {
            while(arr[i]!=0 && x>0)
            {
                pos = (int)(Math.log(leftSetBit(arr[i]))/ Math.log(2));
                //sc.println("Pos" +(pos+1));
                boolean found =false;
                for(int j = i+1;j<=n;j++)
                {
                    boolean yes = ((arr[j] & (1 << (pos+1 - 1))) > 0)? true : false;
                    if(yes) found = true;
                    if (arr[i]!=0 && arr[j]!=0 && yes){
                    arr[j] = arr[j] ^ (1 << (pos+1-1)); //FLIP
                    arr[i] = arr[i] ^ (1 << (pos+1-1)); //FLIP
                    x--;
                    break;
                    }
                }
                if (!found){
                arr[n] = arr[n] ^ (1 << (pos+1-1)); //FLIP
                arr[i] = arr[i] ^ (1 << (pos+1-1)); //FLIP
                x--;
                }
                
                sc.viewArray1D(arr);
                //sc.print("el"+arr[i]+" x="+x+" ");
            }
        }
        if((n==2 && x%2!=0) || (n>=3 && x==1)){
            arr[n] ^=1;
            arr[n-1]^=1;
        }
        for(int i =1;i<=n;i++)
                sc.print(arr[i]+" ");
            sc.println();
        //sc.println(x);
    }
    public static void main(String[] args) 
    {
        // FastReader(true)         for File I/O
        // FastReader()             for terminal I/O
        if(args.length>0 && args[0].equals("local")){
            FastReader sc=new FastReader(true); 
            //CODE BEGIN
            for(int T = sc.nextInt();T > 0;T--)solve(sc);
            //CODE END
            sc.closer();
        }
        else
        {
            FastReader sc=new FastReader(); 
            //CODE BEGIN
            for(int T = sc.nextInt();T > 0;T--)solve(sc);
            //CODE END
            sc.closer();

        }
    }
    static int gcd(int a, int b)
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
    static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
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