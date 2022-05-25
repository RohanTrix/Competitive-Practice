/**
 * IDEA : The question basically asks us the LIS problem but in 2D. Moreover, due to the contrainsts, we cannot
 *        simply do a O(n^2) approach. However, we have a Binary Search based nlog n version of LIS. Clarity of
 *        that algorithm is quite important here.
 *        
 *        The idea is to sort the widths in increasing order and for the same widths, sort the elements in decreasing order
 *        of heights. Then by performing LIS on the we will be able to find the largest number of sequences to be put in the 
 *        
 *        REFER Explanation : https://youtu.be/YLUVx8lXe90
 *        
 */

public class Russian_Doll_Envelopes {
    public int upper_bound(List<Integer> arr, int key)
    {
        int left = 0, right = arr.size()-1;
        int pos = -1;
        while(left<=right)
        {
            int mid = left+(right - left)/2;
            if(arr.get(mid)>= key)
            {
                pos = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return pos;
    }
    public int maxEnvelopes(int[][] envelopes) {
        
        // Increasing sort by width and then decreasing sort by height
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0] == 0?b[1] - a[1]:a[0] - b[0]);
        List<Integer> sol = new ArrayList<>();
        for(int item[] : envelopes)
        {
            int currNum = item[1];
            if(sol.size() == 0 || sol.get(sol.size()-1) < currNum)
                sol.add(currNum);
            else
            {
                int pos = upper_bound(sol, currNum);
                sol.set(pos, currNum);
            }
        }
        return sol.size();
    }
}
