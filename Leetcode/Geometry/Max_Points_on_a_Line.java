/**
 *      NOTE : THIS IS A O(N^3) LOGIC I CAME UP WITH. OPTIMIAL SOLN IS O(N^2)
 *      IDEA : Everytime, we conisder to points to form a line(lets say L). Next, we go through the all points once and increment counter if Point 1 and currPoint
 *             for the same line as line L. To check whether 2 lines are same or not, you can check if they are parallel(smae slope) and if y-intercept
 *             is same. Finally maximise this cnt for each line considered
 * 
 * 
 */

public class Max_Points_on_a_Line {
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
