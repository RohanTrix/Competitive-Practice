//package Solutions;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

@SuppressWarnings("all")


public class Main {
    static class MinIndexedDHeap<T extends Comparable<T>> {

        // Current number of elements in the heap.
        private int sz;
      
        // Maximum number of elements in the heap.
        private final int N;
      
        // The degree of every node in the heap.
        private final int D;
      
        // Lookup arrays to track the child/parent indexes of each node.
        private final int[] child, parent;
      
        // The Position Map (pm) maps Key Indexes (ki) to where the position of that
        // key is represented in the priority queue in the domain [0, sz).
        public final int[] pm;
      
        // The Inverse Map (im) stores the indexes of the keys in the range
        // [0, sz) which make up the priority queue. It should be noted that
        // 'im' and 'pm' are inverses of each other, so: pm[im[i]] = im[pm[i]] = i
        public final int[] im;
      
        // The values associated with the keys. It is very important  to note
        // that this array is indexed by the key indexes (aka 'ki').
        public final Object[] values;
      
        // Initializes a D-ary heap with a maximum capacity of maxSize.
        public MinIndexedDHeap(int degree, int maxSize) {
          if (maxSize <= 0) throw new IllegalArgumentException("maxSize <= 0");
      
          D = max(2, degree);
          N = max(D + 1, maxSize);
      
          im = new int[N];
          pm = new int[N];
          child = new int[N];
          parent = new int[N];
          values = new Object[N];
      
          for (int i = 0; i < N; i++) {
            parent[i] = (i - 1) / D;
            child[i] = i * D + 1;
            pm[i] = im[i] = -1;
          }
        }
      
        public int size() {
          return sz;
        }
      
        public boolean isEmpty() {
          return sz == 0;
        }
      
        public boolean contains(int ki) {
          keyInBoundsOrThrow(ki);
          return pm[ki] != -1;
        }
      
        public int peekMinKeyIndex() {
          isNotEmptyOrThrow();
          return im[0];
        }
      
        public int pollMinKeyIndex() {
          int minki = peekMinKeyIndex();
          delete(minki);
          return minki;
        }
      
        @SuppressWarnings("unchecked")
        public T peekMinValue() {
          isNotEmptyOrThrow();
          return (T) values[im[0]];
        }
      
        public T pollMinValue() {
          T minValue = peekMinValue();
          delete(peekMinKeyIndex());
          return minValue;
        }
      
        public void insert(int ki, T value) {
          if (contains(ki)) throw new IllegalArgumentException("index already exists; received: " + ki);
          valueNotNullOrThrow(value);
          pm[ki] = sz;
          im[sz] = ki;
          values[ki] = value;
          swim(sz++);
        }
      
        @SuppressWarnings("unchecked")
        public T valueOf(int ki) {
          keyExistsOrThrow(ki);
          return (T) values[ki];
        }
      
        @SuppressWarnings("unchecked")
        public T delete(int ki) {
          keyExistsOrThrow(ki);
          final int i = pm[ki];
          swap(i, --sz);
          sink(i);
          swim(i);
          T value = (T) values[ki];
          values[ki] = null;
          pm[ki] = -1;
          im[sz] = -1;
          return value;
        }
      
        @SuppressWarnings("unchecked")
        public T update(int ki, T value) {
          keyExistsAndValueNotNullOrThrow(ki, value);
          final int i = pm[ki];
          T oldValue = (T) values[ki];
          values[ki] = value;
          sink(i);
          swim(i);
          return oldValue;
        }
      
        // Strictly decreases the value associated with 'ki' to 'value'
        public void decrease(int ki, T value) {
          keyExistsAndValueNotNullOrThrow(ki, value);
          if (less(value, values[ki])) {
            values[ki] = value;
            swim(pm[ki]);
          }
        }
      
        // Strictly increases the value associated with 'ki' to 'value'
        public void increase(int ki, T value) {
          keyExistsAndValueNotNullOrThrow(ki, value);
          if (less(values[ki], value)) {
            values[ki] = value;
            sink(pm[ki]);
          }
        }
      
        /* Helper functions */
      
        private void sink(int i) {
          for (int j = minChild(i); j != -1; ) {
            swap(i, j);
            i = j;
            j = minChild(i);
          }
        }
      
        private void swim(int i) {
          while (less(i, parent[i])) {
            swap(i, parent[i]);
            i = parent[i];
          }
        }
      
        // From the parent node at index i find the minimum child below it
        private int minChild(int i) {
          int index = -1, from = child[i], to = min(sz, from + D);
          for (int j = from; j < to; j++) if (less(j, i)) index = i = j;
          return index;
        }
      
        private void swap(int i, int j) {
          pm[im[j]] = i;
          pm[im[i]] = j;
          int tmp = im[i];
          im[i] = im[j];
          im[j] = tmp;
        }
      
        // Tests if the value of node i < node j
        @SuppressWarnings("unchecked")
        private boolean less(int i, int j) {
          return ((Comparable<? super T>) values[im[i]]).compareTo((T) values[im[j]]) < 0;
        }
      
        @SuppressWarnings("unchecked")
        private boolean less(Object obj1, Object obj2) {
          return ((Comparable<? super T>) obj1).compareTo((T) obj2) < 0;
        }
      
        @Override
        public String toString() {
          List<Integer> lst = new ArrayList<>(sz);
          for (int i = 0; i < sz; i++) lst.add(im[i]);
          return lst.toString();
        }
      
        /* Helper functions to make the code more readable. */
      
        private void isNotEmptyOrThrow() {
          if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        }
      
        private void keyExistsAndValueNotNullOrThrow(int ki, Object value) {
          keyExistsOrThrow(ki);
          valueNotNullOrThrow(value);
        }
      
        private void keyExistsOrThrow(int ki) {
          if (!contains(ki)) throw new NoSuchElementException("Index does not exist; received: " + ki);
        }
      
        private void valueNotNullOrThrow(Object value) {
          if (value == null) throw new IllegalArgumentException("value cannot be null");
        }
      
        private void keyInBoundsOrThrow(int ki) {
          if (ki < 0 || ki >= N)
            throw new IllegalArgumentException("Key index out of bounds; received: " + ki);
        }
      
        /* Test functions */
      
        // Recursively checks if this heap is a min heap. This method is used
        // for testing purposes to validate the heap invariant.
        public boolean isMinHeap() {
          return isMinHeap(0);
        }
      
        private boolean isMinHeap(int i) {
          int from = child[i], to = min(sz, from + D);
          for (int j = from; j < to; j++) {
            if (!less(i, j)) return false;
            if (!isMinHeap(j)) return false;
          }
          return true;
        }
      }
    Map<Integer, Set<pair>> edges = new HashMap<>();
    boolean visited[];
    int prev[];
    void solver(FastReader sc) throws IOException{
        
        int n = sc.nextInt(), m = sc.nextInt();
        
        visited = new boolean[n+1];
        for(int i =1; i<=n;i++)
            addNode(i);
        
        for(int i =1; i<=m; i++)
            addEdge(sc.nextInt(), sc.nextInt(), sc.nextLong());
        
        int s = 1;
        long dist[] = dijkstra_lazy(n, 1);
        for(int i =1; i<dist.length; i++) sc.print(dist[i]+" ");
        
    }
    long[] dijkstra_lazy(int numNodes, int start)
    {
        // prev = new int[numNodes+1];
        // Arrays.fill(prev,-1);
        long dist[] = new long[numNodes+1];
        Arrays.fill(dist, Long.MAX_VALUE/2);

        long newDist = 0L;
        dist[start] = (long) 0;
        MinIndexedDHeap ipq = new MinIndexedDHeap(2, numNodes);
        ipq.insert(start-1, 0L);
        //PriorityQueue<pair> pq = new PriorityQueue<>();
        
        while(ipq.size()!=0)
        {
            int currNode = ipq.peekMinKeyIndex();
            visited[currNode] = true;

            long weight = (long)ipq.pollMinValue();
            if(dist[currNode] <weight) continue;

            for(pair to : edges.get(currNode+1))
            {
                if(visited[to.neighbour-1]) continue;

                newDist = dist[currNode] + to.weight;
                
                if(newDist < dist[to.neighbour-1])
                {
                    //prev[to.neighbour] = currNode.neighbour;
                    dist[to.neighbour-1] = newDist;
                    if(!ipq.contains(to.neighbour-1))
                        ipq.insert(to.neighbour-1, newDist);
                    else
                        ipq.decrease(to.neighbour-1, newDist);
                }
            }
            
        }
        return dist;
    }

    public void addNode(int u) {
        if (!edges.containsKey(u)) {
          edges.put(u, new HashSet<pair>());
        }
      }
      public void addEdge(int u, int v, long w) {
        edges.get(u).add(new pair(v,w));
        //edges.get(v).add(u);
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

    static class pair<neighbour,weight> implements Comparable < pair<neighbour,weight> >
    {
      int neighbour;
      long weight;
      pair(int i, long j) {
          neighbour = i;
          weight = j;
      }
      public int compareTo(pair p) {
          return Long.compare(this.weight,p.weight);
          
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