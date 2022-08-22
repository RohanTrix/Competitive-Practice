public class Coordinate_With_Maximum_Network_Quality
{
    // IDEA : Points are brute forcable since they lie between (0,0) to (50,50). For each point find
    //        the total quality given by valid towers, save the (posx, posy) for the best quality
    class Point
    {
        int x, y;
        public Point(int x, int y)
        {
            this.x = x; this.y = y;
        }
    }
    public double getDist(Point p, Point q)
    {
        return Math.sqrt((p.x - q.x)*(p.x - q.x) + (p.y - q.y)*(p.y - q.y));
    }
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        double bestQuality = 0.0;
        int bestX = 0, bestY = 0;
        for(int posx = 0; posx<=50; posx++)
            for(int posy = 0; posy<=50; posy++)
            {
                Point currLoc = new Point(posx, posy);
                double totQuality = 0;
                for(int tow[] : towers)
                {
                    int x = tow[0], y = tow[1], q = tow[2];
                    double currDist = getDist(currLoc, new Point(x,y));
                    if(currDist>radius) continue;
                    totQuality+=Math.floor((1.0*q)/(1+currDist));
                }
                if(totQuality>bestQuality)
                {
                    bestQuality = totQuality;
                    bestX = posx; bestY = posy;
                }
            }
        return new int[]{bestX, bestY};
    }
}