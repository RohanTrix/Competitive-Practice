/**
 *      IDEA : Remember to sort the positions. Since the question has a maximisation of minimum dist b/w balls,
 *             this makes it binary searching on the answer....We search for a minimum distance between
 *             any 2 balls(we only care abt adjacent balls because other pairs will be of course larger than adjacent)
 *             
 *             So the greedy logic of the binary search is to place a ball at first position...and then keep
 *             skipping the next positions if its distance to the previous position is LESS THAN the minimum
 *             we have chosen in our binary search.....the possible function returns true if we were able to place
 *             m balls or more this way...if yes..we can store answer and increase the minimum distance
 *             otherwise decrease.
 */
public class Magnetic_Force_Between_Two_Balls
{
    public boolean possible(int pos[], int dist, int balls)
    {
        balls--;
        int prev = pos[0];
        for(int nextPos : pos)
        {
            if(nextPos - prev < dist)
                continue;
            balls--;
            prev = nextPos;
        }
        return balls<=0;
        
    }
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int l = 0, r = (int)1e9;
        int ans = -1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(possible(pos, mid, m))
            {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
}