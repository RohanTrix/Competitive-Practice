import java.util.Arrays;

/**
 *      IDEA : i < j condition just tells us that we need to pick different elements. Since no other part of the questions constraints
 *             us on i,j...it is best to SORT the array. After sorting, it is easy to solve the question for each arr[i]
 * 
 *             According to the relation : lower <= nums[i] + nums[j] <= upper
 * 
 *                  If we fix ith element, then the only variable is nums[j].....increasng nums[j] can make it go beyond `upper` or decreasing nums[j] can
 *                  make it go below `lower`.....we need to find these endpoints....and they are binary searchable into 2 different relations
 * 
 *                          1) lower - nums[i] <= nums[j]   ----> Find the least nums[j] such that this relation holds
 *                          2) nums[j] <= upper - nums[i]   ----> Find the highest nums[j] such that this relation holds
 * 
 *                  Current nums[i] can pair up with all elements in thi subarray range, so we add the # of the elements in it to final ans.
 *                  And we do this for every nums[i]
 * 
 */


public class Count_the_Number_of_Fair_Pairs {
    int nums[];
    public int bsLeft(int i, int val){
        int l = 0, r = i-1;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(val - nums[i] <= nums[mid])
            {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
    
    public int bsRight(int i, int val){
        int l = 0, r = i-1;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] <= val - nums[i])
            {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
    
    public long countFairPairs(int[] nums, int lower, int upper) {
        this.nums = nums;
        int n = nums.length;
        Arrays.sort(nums);
        long cnt = 0;
        for(int i = 1; i<n; i++){
            int ind1 = bsLeft(i, lower);
            int ind2 = bsRight(i, upper);
            if(ind1==-1 || ind2==-1) continue;
            cnt+=ind2-ind1+1;
        }
        return cnt;
    }
}
