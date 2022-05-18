public class Queries_on_Number_of_Points_Inside_a_Circle {
    // Condition for point inside circle :
    //          Dist between centre of circle and point should be less than radius
    //          (x-xi)^2 + (y-yi)^2 <= r^2
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = points.length;
        int q = queries.length;
        int res[] = new int[q];
        for(int i = 0; i<q; i++)
        {
            int cnt = 0;
            int x = queries[i][0], y = queries[i][1], radius = queries[i][2];
            for(int j = 0; j<n; j++)
            {
                if(Math.pow(x - points[j][0], 2) + Math.pow(y - points[j][1], 2) <= radius*radius)
                    cnt++;
            }
            res[i] = cnt;
        }
        return res;
    }
}
