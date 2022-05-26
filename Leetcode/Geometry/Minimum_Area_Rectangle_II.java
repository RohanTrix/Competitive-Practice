/**
 *      IDEA : IMP NOTE : A rectangle's diagnols 
 *                          1) have same length and, 
 *                          2) have same mid point / meet at midpoint.
 *              
 *             PairPoint class ==> Pair of points...(x1,y1) and (x2,y2) as a object
 *
 *             We will create a Map<Long, List<PointPair>> map :
 *                          It maps the length of a diagnol to a list of PairPoints which make a diagnol of that length.
 *             
 *             Now, using the 1st condition of rectangle's diagnol, for a current diagnol length,
 *             we will consider on pair of PairPoints(4 points in total). Now we check for the 2nd condition: if the mid-points
 *             of both the diagnols are same or not.
 *             
 *             IF they are, this means it is a rectangle and we find the 2 distances, by taking one point from first PairPoint
 *             and finding distance with the 2 points in second PairPoint.
 *             
 *             Finally, update the minimum area.
 *             
 */
public class Minimum_Area_Rectangle_II
{
    public double minAreaFreeRect(int[][] points) {
        Map<Long, List<PointPair>> map = new HashMap<>();
        int n = points.length;
        
        // Mapping dist -> pair of points with that dist
        for(int i = 0; i<n; i++)
            for(int j = i+1; j<n; j++)
            {
                Long dist = getDist(points[i], points[j]);
                map.computeIfAbsent(dist, k -> new ArrayList<>()).add(new PointPair(points[i], points[j]));
            }
        
        double area = Double.MAX_VALUE;
        for(long dist : map.keySet())
        {
            List<PointPair> list = map.get(dist);
            for(int i = 0; i<list.size(); i++)
            {
                for(int j = i+1; j<list.size(); j++)
                {
                    PointPair pair1 = list.get(i);
                    double midPoint1[] = getMidPoint(pair1);
                    PointPair pair2 = list.get(j);
                    double midPoint2[] = getMidPoint(pair2);
                    
                    if(isEqual(midPoint1, midPoint2))
                    {
                        double length1 = Math.sqrt(getDist(new int[]{pair1.x1, pair1.y1}, new int[]{pair2.x1, pair2.y1}));
                        double length2 = Math.sqrt(getDist(new int[]{pair1.x1, pair1.y1}, new int[]{pair2.x2, pair2.y2}));
                        area = Math.min(area, length1*length2);
                    }
                }
            }
        }
        return area==Double.MAX_VALUE?0:area;
        
    }
    public long getDist(int P1[], int P2[])
    {
        long x = Math.abs(P1[0] - P2[0]);
        long y = Math.abs(P1[1] - P2[1]);
        return x*x + y*y;
    }
    public double[] getMidPoint(PointPair p)
    {
        double xmid = 1.0*(p.x1+p.x2)/2;
        double ymid = 1.0*(p.y1+p.y2)/2;
        return new double[]{xmid,ymid};
    }
    public boolean isEqual(double P1[], double P2[])
    {
        return P1[0] == P2[0] && P1[1] ==  P2[1];
    }
    
    class PointPair
    {
        int x1, y1, x2, y2;
        public PointPair(int P1[], int P2[])
        {
            this.x1 = P1[0];
            this.y1 = P1[1];
            this.x2 = P2[0];
            this.y2 = P2[1];
        }
        public String toString()
        {
            return "(P1 : "+x1+" "+y1+"\tP2: "+x2+" "+y2+")";
        }
    }
}