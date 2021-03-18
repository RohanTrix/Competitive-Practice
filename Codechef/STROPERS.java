package Codechef;

import java.io.*;
import java.util.*;

public class STROPERS {
    /*
    static String sub_check(String p, int n) {
        StringBuilder sb = new StringBuilder(p);
        // return sb.reverse().toString().equals(b.substring(i,j+1));
        //System.out.println("CHECKING "+p);
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1')
                continue;
            else {
                int ptr = sb.indexOf("1", i + 1);

                if(ptr==-1 || sb.lastIndexOf("1") ==ptr) return sb.toString();
                //System.out.println(ptr);
                ptr = sb.indexOf("1", ptr + 1);
                //System.out.println(ptr);
                if (ptr != -1) {
                    StringBuilder ss = new StringBuilder(sb.substring(i, ptr + 1));
                    ss = ss.reverse();
                    sb.replace(i, ptr + 1, ss.toString());
                } else
                    return sb.toString();
            }
        }
        // System.out.println(sb.toString());
        return sb.toString();

    }
    
    static boolean check(String p, String q, int n) {
        // StringBuilder sb = new StringBuilder(q);

        // String s1 = sub_check(p, n);
        //System.out.println(p+ " "+q);
        if (sub_check(p, n).equals(sub_check(q, n)))
            return true;
        return false;

    }
    */
    static ArrayList<Integer> counter(String p, int n)
    {
        int pairs = 0;
        int count =0;
        int ones = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 0;i<n;i++)
        {
            if(p.charAt(i) == '1'){
                pairs ^=1;
                ones++;
            }

            if(p.charAt(i) =='0' && pairs==1)
                count++;
        }
        //arr = {ones,count};
        al.add(ones); al.add(count);
        return al;

    }
    static void solve(FastReader sc) {
        String s = sc.next();
        int n = s.length();
        // StringBuilder sb = new StringBuilder(s);
        //HashMap<Integer, HashSet<String>> baskets = new HashMap<Integer, HashSet<String>>();
        HashSet<ArrayList<Integer>> hs;
        int cnt = 0;
        for (int len =1; len<=n;  len++) {
            hs = new HashSet<ArrayList<Integer>>();
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                hs.add(counter(s.substring(i, j+1), len));
            }
            cnt+=hs.size();
        }
        //System.out.println(baskets);
        sc.println(cnt);

    }

    /*
     * static void solve(FastReader sc) { String s1 = sc.next(); String s2 =
     * sc.next(); int n = s1.length(); sc.print(check(s1,s2,n));
     * 
     * }
     */
    public static void main(String[] args) {
        // FastReader(true) for File I/O
        // FastReader() for terminal I/O
        if (args.length > 0 && args[0].equals("local")) {
            FastReader sc = new FastReader(true);
            // CODE BEGIN
            for (int T = sc.nextInt(); T > 0; T--)
                solve(sc);
            // CODE END
            sc.closer();
        } else {
            FastReader sc = new FastReader();
            // CODE BEGIN
            for (int T = sc.nextInt(); T > 0; T--)
                solve(sc);
            // CODE END
            sc.closer();

        }
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void fill2D(int arr[][], int n) {
        for (int[] row : arr)
            Arrays.fill(row, n);
    }

    static class pair implements Comparable<pair> {
        long x;
        long y;

        pair(long i, long j) {
            x = i;
            y = j;
        }

        public int compareTo(pair p) {
            if (this.x != p.x) {
                return Long.compare(this.x, p.x);
            } else {
                return Long.compare(this.y, p.y);
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

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        PrintWriter pw;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(new OutputStreamWriter(System.out));
        }

        public FastReader(boolean b) {
            try {
                br = new BufferedReader(new FileReader("input.txt"));
                pw = new PrintWriter("output.txt");

            } catch (Exception e) {

            }

        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    pw.print(' ');
                pw.print(objects[i]);
            }
        }

        void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    pw.print(' ');
                pw.print(objects[i]);
            }
            pw.println();
        }

        void viewArray1D(Object a[]) {
            println(Arrays.toString(a));
        }

        /*
         * void viewArray2D(int arr[][]) { for (int[] row: arr) viewArray1D(row); }
         */
        void closer() {
            try {
                br.close();
                pw.flush();
                pw.close();
            } catch (Exception e) {
            }
        }
    }
}