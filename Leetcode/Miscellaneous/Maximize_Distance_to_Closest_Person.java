public class Maximize_Distance_to_Closest_Person
{
    // Two pointer solution
    // the best dist between 2 persons is on the middle seat...if even no. of seats...then its dist will be the larger the distance.
    // This can easily be achieved by seal....and 2 edge cases when consider beginning to first person....and last person to end of seats 
    // are handled in the if case.
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int left = -1;
        int maxi = 0;
        for(int right = 0; right<=n; right++)
        {
            if(right!=n && seats[right] == 0)
                continue;
            int mid = 0;
            if(left == -1 || right == n)
                mid = right - left-1;
            else
                mid = (right-left)/2; // Equation by taking ceil (no. of seats in middle/2
            maxi = Math.max(maxi, mid);
            left = right;
        }
        return maxi;
    }
}