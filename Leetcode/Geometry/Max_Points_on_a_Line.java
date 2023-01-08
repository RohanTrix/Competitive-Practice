import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *      
 *      EXPLANATION ONLY :(https://leetcode.com/problems/max-points-on-a-line/solutions/47106/c-o-n-2-solution-for-your-reference/?orderBy=most_votes)
 *      CODED BY SELF
 */

 class Solution {
    public int maxPoints(int[][] points) {
        int maxi = 0;
        int n = points.length;
        Map<Slope, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            int x1 = points[i][0], y1 = points[i][1];
            
            for(int j = i+1; j<n; j++)
            {
                int x2 = points[j][0], y2 = points[j][1];
                Slope del = new Slope(y2 - y1, x2 - x1);
                map.put(del, map.getOrDefault(del, 0)+1);
                maxi = Math.max(maxi, map.get(del));
            }
            map.clear();
        }
        return maxi+1;
    }
    class Slope
    {
        int dy, dx;
        public Slope(int dy, int dx)
        {
            int g = gcd(dy,dx);
            dy/=g; dx/=g;    
            this.dy = dy;
            this.dx = dx;
            
        }
        public int gcd(int a, int b)
        {
            if(a == 0)
                return b;
            return gcd(b % a, a);
        }
        @Override
        public boolean equals(Object o)
        {
            Slope that = (Slope) o;
            return this.dx == that.dx && this.dy == that.dy;
        } 
        public int hashCode()
        {
            return Objects.hash(dx,dy);
        }
    }
}


/**
 * NOTE : THIS IS A O(N^3) LOGIC I CAME UP WITH.
 * IDEA : Everytime, we conisder two points to form a line(lets say L). Next, we go through the all points once and increment counter if line formed by Point 1 and currPoint
 *             is the same line as line L. To check whether 2 lines are same or not, you can check if they are parallel(smae slope) and if y-intercept
 *             is same. Finally take max of this cnt for all lines L considered
 */
class Max_Points_on_a_Line1 {
    public int maxPoints(int[][] points) {
        int maxi = 1;
        for(int p1[] : points)
            for(int p2[] : points)
            {
                Point P1 = new Point(p1[0], p1[1]);
                Point P2 = new Point(p2[0], p2[1]);
                if(P1.isSame(P2))
                    continue;
                Line curr = new Line(P1, P2);
                int cnt = 1;
                for(int p3[] : points)
                {
                    Point P3 = new Point(p3[0], p3[1]);
                    if(P1.isSame(P3))
                        continue;
                    Line other = new Line(P1, P3);
                    if(curr.isSame(other))
                        cnt++;
                }
                maxi = Math.max(maxi, cnt);
            }
        return maxi;
    }
    class Line {
        double a, b, c;
        final double EPS = 1e-9;
        public Line(Point p1, Point p2) 
        {
            if (Math.abs(p1.x - p2.x) < EPS) 
            {
                a = 1.0;
                b = 0.0;
                c = -p1.x;
            } 
            else 
            {
                a = -1.0 * (p1.y - p2.y) / (p1.x - p2.x);
                b = 1.0;
                c = -1.0 * (a * p1.x) - p1.y;
            }
        }
        public boolean isParallel(Line l) 
        {
            return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
        }
        // Same Lines check
        public boolean isSame(Line l) 
        {
            return isParallel(l) && Math.abs(c - l.c) < EPS;
        }
    }
    class Point{
        int x, y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public boolean isSame(Point that)
        {
            return this.x == that.x && this.y == that.y;
        }
    }
}
