//package Solutions;

import java.io.*;
import java.util.*;

@SuppressWarnings("all")

public class Main {
    public Map<Integer, Set<Integer>> edges = new HashMap<>();
    int visited[], parent[];
   
    
    void solver(FastReader sc) throws IOException{
        

        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++)
            addNode(i);
        for (int i = 0; i < m; i++)
            addEdge(sc.nextInt(), sc.nextInt());
        
        visited = new int[n+1];
        
        Arrays.fill(visited, 0);
        for(int i = 1; i<=n; i++)
        {
            if(f)break;
            if(visited[i]==0)
            {
                dfs(i,-1);
            }
        }
        if(!f)
            sc.println("IMPOSSIBLE");
        else
            {
                sc.println(count+1);
                sc.println(path);
            }


    }

    void addNode(int u) {
        edges.put(u, new TreeSet<>());
    }

    void addEdge(int u, int v) {
        edges.get(u).add(v);
        edges.get(v).add(u);
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