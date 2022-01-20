public class Number_of_Pairs_of_Interchangeable_Rectangles {
    public int gcd(int a, int b)
    {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    public long interchangeableRectangles(int[][] rects) {
        HashMap<pair, Integer> hm = new HashMap<>();
        long cnt = 0;
        
        for(int r[]: rects)
        {
            int g = gcd(r[0],r[1]);
            int x = r[0]/g;
            int y = r[1]/g;
            pair p = new pair(x,y);
            if(hm.containsKey(p)) cnt+=hm.get(p);
            hm.put(p, hm.getOrDefault(p,0)+1);
        }
        return cnt;
    }
    static class pair
    {
        int num1, num2;
        public pair(int a, int b)
        {
            num1 = a; num2 = b;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof pair)) return false;
            pair that = (pair)o;
            return num1 == that.num1 && num2 == that.num2;
        }
        
        @Override
        public int hashCode() {
            return num1 ^ num2;
        }
    }
}
