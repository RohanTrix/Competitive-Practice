/* Algorithm:

We need to use a Binary Search as our search space is the number of days and the upper limit for the day is 10^9. 
We binary search from l = min(days) to r = max(days) as flowers will bloom within this range only. 
Now, we pass our mid from binary search to a possible function which returns 
whether we can make >=m bouquets or not. This is implemented greedily by adding
adj flowers until a bloom day is more than 
the curr day. And if at any point we have k flowers adjacent, we increase our no. of bouquets by 1. At the end, 
we return a boolean whether counted no. of bouquets>= m( required no. of bouqets). If this func returns true,
that means we can make at least m bouquets in mid days. This suggests that at least m bouquets can also be made in
mid + some d days too. Thus, we store the answer and search for a better one on the left part of the array.
Else, we need to find a valid answer and hence search in the right part of the array.

*/


package Leetcode.Binary_Search;
import java.util.stream.*;
class Minimum_Number_of_Days_to_Make_m_Bouquets {
    public boolean possible(int[] days, int m, int k, int currDay)
    {
        int bouqs = 0,adj = 0;
        for( int i =0 ;i<days.length;i++)
        {
            adj+=1;
            if(days[i]> currDay)
            {
                adj = 0;
            }
            if(adj==k)
            {
                bouqs+=1;
                adj = 0;
            }
        }
        return bouqs>=m;
    }
    public int minDays(int[] days, int m, int k) {
        
        int l = IntStream.of(days).min().getAsInt();
        int r = IntStream.of(days).max().getAsInt();
        int bestans = -1;
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(possible(days, m, k, mid))
            {
                bestans = mid;
                r = mid-1;
            }
            else
                l = mid+1;
        }
        return bestans;
    }
}
