package Leetcode.Miscellaneous;
/* IDEA:
        The idea is to keep track and update current the current Sum at every query.
        If nums[ind] is even, we first remove it from the currSum as later it might be changed to ODD/EVEN.
        We make the update on nums with val. (regardless of it being EVEN/ODD, cuz its necessary)
        Now if after update, the value is still EVEN, then we add the updated number to currSum
        and save it in ans[q]. 
*/
public class Sum_of_Even_Numbers_After_Queries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int ans[] = new int[queries.length];
        int currSum = 0;
        for(int i =0; i<n; i++)
            currSum+=(nums[i]%2==0)?nums[i]:0;
        
        for(int q = 0; q<queries.length;q++)
        {
            int val = queries[q][0],ind = queries[q][1];
            if(nums[ind]%2==0)
            {
                currSum-=nums[ind];
            }
            nums[ind]+=val;
            if(nums[ind]%2==0)
                    currSum+=nums[ind];
            ans[q] = currSum;
        }
        return ans;
    }
}

