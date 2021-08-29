import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
@SuppressWarnings("all")
public class Main 
{
    static int dr[] = {0,0,1,-1};
    static int dc[] = {-1,1,0,0};
    static String fin = "-1";
    static int endi,endj;
   
    static void solve(FastReader sc)
    {
        int n = sc.nextInt(), m = sc.nextInt();
        char mat[][] = new char[n][m];
        char path[] = new char[n][m];
        int si = 0 ,sj = 0;
        Queue<pair> q = new LinkedList<>();
        for( int i = 0; i<n; i++)
        {
            char a[] = sc.next().toCharArray();
            for(int j = 0; j<m; j++) 
            {
                if(a[j]=='A')
                q.offer(new pair(i,j));
                if(a[j]=='B')
                {endi = i; endj = j;}
            }
            mat[i] = a;
        }
        
        while(!q.isEmpty())
        {
            pair tmp = q.poll();
            if(tmp.x==endi && tmp.y==endj)
            {
                
            }
        }
        


        if(fin.equals("-1"))
        {
            sc.println("NO");
            return;
        }            
        /*
        for(int i = 0;i<n;i++)
        {
            for(int j = 0; j<m;j++)
            {
                sc.print(mat[i][j]);
            }
            sc.println();
        }
        */
        sc.println("YES");
        sc.println(fin.length());
        sc.print(fin);
        
    }
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
        int x;
        int y;
        pair(int i, int j) {
            x = i;
            y = j;
        }
        public int compareTo(pair p) {
            if (this.x != p.x) {
                return Integer.compare(this.x,p.x);
            } else {
                return Integer.compare(this.y,p.y);
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