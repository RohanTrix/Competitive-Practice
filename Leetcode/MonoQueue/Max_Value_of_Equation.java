public class Max_Value_of_Equation {
    // REFER: https://youtu.be/mSnghkVXyvA
    public int findMaxValueOfEquation(int[][] points, int k) {

        int maxi = Integer.MIN_VALUE;
        Deque<int[]> q = new ArrayDeque<>(); // decreasing queue
        int n = points.length;

        for(int i = 0; i<n; i++)
        {
            // We will remove all the jth points before ith point whose (xi-xj) > k
            while(!q.isEmpty() && points[i][0]-q.peekFirst()[0]>k)
                q.pollFirst();
            
            // We store the max points we can get. The front of the queue has the largest (yj-xj) right now.
            if(!q.isEmpty())
            {
                int xj = q.peekFirst()[0], yj = q.peekFirst()[1];
                
                maxi = Math.max(maxi, (yj-xj) + points[i][0]+points[i][1]);
            }
            // Now we need to insert the current (yi-xi) in a sorted position in the deque
            while(!q.isEmpty() && (q.peekLast()[1] - q.peekLast()[0])<= (points[i][1]-points[i][0]))
                q.pollLast();
            
            // Add the new element in the queue
            q.offerLast(points[i]);  
        }
        return maxi;
    }
}
