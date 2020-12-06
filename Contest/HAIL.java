import java.io.*;
import java.util.*;
public class HAIL
{
    static void solve(FastReader sc)
    {
        int n = sc.nextInt(); int x = sc.nextInt();
        int bitset[][] = new int[30+1][n+1];
        int xor =0;int k, totPair = 0;
        int arr[] = new int[n+1];
        for(int j=1;j<=n;j++)
        {
            arr[j] = sc.nextInt();
            xor^=arr[j];
            k=1;
            for(int i=30;i>=1;i--)
                {
                    //sc.println("k="+k+"  "+((arr[j] & (1 << (k - 1))) >> (k - 1)));
                    bitset[i][j] = ((arr[j] & (1 << (k - 1))) >> (k - 1));
                    k++;
                }
        }
        //sc.viewArray1D(arr);
        //sc.viewArray2D(bitset);
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        int sum = 0;
        for(int i=1;i<=30;i++)
        {
            sum=0;
            map.put(i, new LinkedList<Integer>());
            for(int j =1; j<=n;j++)
            {
                if( bitset[i][j] == 1)
                {
                    sum++;
                    map.get(i).offer(j);
                }
            }
            totPair+= (sum/2) +(sum%2);
            if( map.get(i).size()%2!=0)
                map.get(i).offer(n);
        }
        if(totPair >=x)
        {
            for(int i=1;i<=n-1;i++)
            {
                arr[i] = 0;
            }
            arr[n]=xor;
        }
        else
        {
            for(int j =1;j<=n;j++)
            {
                for(int i=1;i<=30;i++)
                {
                    if(x>0 && map.get(i).size()!=0 && j==map.get(i).peek())
                    {
                        int a = map.get(i).remove();
                        int b = map.get(i).remove();
                        arr[a] ^= (1 << ((30-i+1)-1));
                        arr[b] ^= (1 << ((30-i+1)-1));
                        x--;
                    }
                }
            }
        }
        for(int i=1;i<=n;i++)
        sc.print(arr[i]+" ");


        
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