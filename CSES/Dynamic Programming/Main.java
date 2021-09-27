//package Solutions;

import java.io.*;
import java.util.*;

@SuppressWarnings("all")

public class Main {
    long dp[];
    long mod = 1000000007;
    long dfs(int u, int coins[])
    {
        if(u<0)return 0L;
        if(u==0)return 1L;
        if(dp[u]!=0)return dp[u];
        for(int currCoin = 0; currCoin<coins.length; currCoin++)
        {
            if(coins[currCoin]>u)break;
            dp[u]+=dfs(u-coins[currCoin], coins);
            dp[u]%=mod;
        }
        return dp[u]%mod;
    }
    void solver(FastReader sc) throws IOException{
        int n = sc.nextInt();
        int target = sc.nextInt();
        int coins[] = sc.nextArray(n);
        Arrays.sort(coins);
        dp = new long[target+1];
        Arrays.fill(dp,0);
        sc.println(dfs(target, coins));
        //sc.println(Arrays.toString(dp));
        


    }

    static void solve(FastReader sc) throws IOException {
        Main ob = new Main();
        ob.solver(sc);
    }

    public static void main(String[] args)throws IOException {
        // FastReader(true) for File I/O
        // FastReader() for terminal I/O
        if (args.length > 0 && args[0].equals("local")) {
            FastReader sc = new FastReader(true);
            // CODE BEGIN
            // for(int T = sc.nextInt();T > 0;T--)
            solve(sc);
            // CODE END
            sc.closer();
        } else {
            FastReader sc = new FastReader();
            // CODE BEGIN
            // for(int T = sc.nextInt();T > 0;T--)
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

    static void fill2D(char arr[][], char n) {
        for (char[] row : arr)
            Arrays.fill(row, n);
    }

    static class pair {
        int x;
        int y;

        pair(int i, int j) {
            x = i;
            y = j;

        }

        public String toString() {
            return x + " " + y;
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

        void viewArray1D(int a[]) {
            println(Arrays.toString(a));
        }

        void viewArray2D(int arr[][]) {
            for (int[] row : arr)
                viewArray1D(row);
        }

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