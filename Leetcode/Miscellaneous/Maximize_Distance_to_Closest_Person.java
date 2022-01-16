public class Maximize_Distance_to_Closest_Person
{
    // Two pointer solution
    // Find dist from start to first person
    // Find the best dist between every two person using 2 pointer logic
    // Find the dist be
    public int maxDistToClosest(int[] seats) {
        
        int left = -1, right = 0;
        int n = seats.length; 
        
        int maxi = 0;
        while(seats[right]!=1)right++;
        maxi = Math.max(maxi, right-1 - (left+1) + 1);
        left = right;
        right++;
        for(;right<n; right++)
        {
            if(seats[right] == 1)
            {
                int val = right-1 - (left+1) + 1;
                maxi = Math.max(maxi, (val+1)/2);
                left = right;
            }
        }
        maxi = Math.max(maxi, right-1 - (left+1) + 1);
        return maxi;
    }
}