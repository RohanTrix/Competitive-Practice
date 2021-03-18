package Codechef;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;  
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.FileReader;
public class POLYREL
{ 
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

    public static void solve(FastReader sc)
    {
        int num = 0;
        int n = sc.nextInt();
        for(int k=0;k<n;k++)
            sc.nextLine();
        while(n>5)
        {
            num+=n;
            n = (int) n/2;
        }
        sc.println(num + n);
        }
    
    public static void main(String[] args) 
    {
        // FastReader(true)         for File I/O
        // FastReader()             for terminal I/O    

        FastReader sc=new FastReader(); 

        //CODE BEGIN

        int t = sc.nextInt();
        while(t-- > 0)
        {
            solve(sc);
        }


        //CODE END

        // sc.flush() if the output needs to be flushed
        sc.closer();
    } 
}