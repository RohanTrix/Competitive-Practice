import java.io.*;
import java.util.*;
public class Solution 
{
    public static int count(int nums[][], int i,int j, int hor, int ver)
    {
        int a = nums[i][j];
        int c = 1;
        while(a==nums[i][j])
        {
            i+=hor;
            j+=ver;
            if(i<0 || i>=nums.length || j<0 || j>=nums[0].length) break;
            if(nums[i][j]==1) c++;
            else break;
        }
        return c;
    }
    public static int getans(int left, int up)
    {  
        int maxi = Math.max(left, up);
        int mini = Math.min(left,up);
        int eve1 = Math.max(0,mini/2 -1);
        int eve2 = Math.max(0, Math.min(2*mini, maxi)/2 -1 );
        return eve1 + eve2;
        
    }
    static void solve(FastReader sc, int t)
    {
        int n = sc.nextInt(), m = sc.nextInt();
        int matrix[][] = new int[n][m];

        for( int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        int left, right, up, down;


        int ans = 0;
        for( int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {            
                if(matrix[i][j]==0) continue;
                left = count(matrix,i,j,0,-1);
                down = count(matrix, i , j,1, 0);
                right = count(matrix, i , j,0, 1);
                up = count(matrix, i , j,-1,0);

                //sc.println(i+" "+j+" ||| "+left+" "+right+" "+up+" "+down);
                //sc.println(getans(left, down)+" " + getans(left, up) +" "+ getans(right, down) + " "+getans(right, up));
                ans+=getans(left, down)+ getans(left, up) + getans(right, down) + getans(right, up);
            }
        }
        

        sc.println("Case #"+t+": "+ans);

        
    }
    public static void main(String[] args) 
    {
        // FastReader(true)         for File I/O
        // FastReader()             for terminal I/O
        if(args.length>0 && args[0].equals("local")){
            FastReader sc=new FastReader(true); 
            //CODE BEGIN
            int t = sc.nextInt();
            for(int T = 1;T <=t ;T++)solve(sc, T);
            //CODE END
            sc.closer();
        }
        else
        {
            FastReader sc=new FastReader(); 
            //CODE BEGIN
            int t = sc.nextInt();
            for(int T = 1;T <=t ;T++)solve(sc, T);
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