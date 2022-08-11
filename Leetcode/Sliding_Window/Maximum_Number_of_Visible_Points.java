/*
 *      IDEA : Explained in OneNote
 *      CRUX : Use Sliding Window on angles formed by points with respect to location
 * 
 */
public class Maximum_Number_of_Visible_Points {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int n = points.size();
        int base = 0;
        int locx = location.get(0), locy = location.get(1);
        List<Double> thetas = new ArrayList<>();
        for(List<Integer> point : points)
        {
            int h = point.get(1) - locy;
            int b = point.get(0) - locx;
            if(h == 0 && b == 0)
                base++;
            else
                thetas.add(Math.toDegrees(Math.atan2(h, b)));
        }
        // debug(thetas);
        
        Collections.sort(thetas);
        n = thetas.size();
        for(int i = 0; i<n; i++)
            thetas.add(360 + thetas.get(i));
        
        int left = 0, maxi = 0;
        for(int right = 0; right<thetas.size(); right++)
        {
            while(left<right && thetas.get(right) - thetas.get(left) > angle)
                left++;
            maxi = Math.max(maxi, right - left + 1);
        }
        return maxi + base;
    }
}
