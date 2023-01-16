package Leetcode.Binary_Search;


import java.util.stream.*;
class Capacity_To_Ship_Packages_Within_D_Days {
    /*
Binary search probably would not come to our mind when we first meet this problem.
 We might automatically treat weights as search space and then realize we've entered a dead end
  after wasting lots of time. In fact, we are looking for the minimal one among all feasible capacities.
   We dig out the monotonicity of this problem: if we can successfully ship all packages within D days 
   with capacity m, then we can definitely ship them all with any capacity larger than m. 
   Now we can design a condition function, let's call it feasible, given an input capacity, 
   it returns whether it's possible to ship all packages within D days. 
   This can run in a greedy way: if there's still room for the current package, we put this package onto
    the conveyor belt, otherwise we wait for the next day to place this package. If the total days needed exceeds D,
    we return False, otherwise we return True.
Next, we need to initialize our boundary correctly.
 Obviously capacity should be at least max(weights), otherwise the conveyor belt couldn't ship the heaviest package.
  On the other hand, capacity need not be more thansum(weights), because then we can ship all packages
   in just one day.
*/
public boolean feasible(int weights[],int cap, int D)
{
    int days = 1;
    int total = 0;
    for(int i = 0;i<weights.length;i++)
    {
        total+=weights[i];
        if(total>cap)
        {
            days++;
            total=weights[i]; // Resetting total to the last item which couldnt be added                                   // to previous day
        }
        
    }
    return days<=D;
}
public int shipWithinDays(int[] weights, int D) {
    int l = IntStream.of(weights).max().getAsInt(); // Max of array will be lower bound
                                                   // as that is minimum capacity for                                                            // belt
    int r = IntStream.of(weights).sum();
    int bestans = -1;
    while(l<=r)
    {
        int mid = l + (r-l)/2; // A certain capacity is chosen
        if(feasible(weights,mid, D)){
            bestans = mid;
            r = mid-1;
        }
        else
            l = mid+1;
        
    }
    return bestans;

}

}
