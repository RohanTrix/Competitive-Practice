class Search_in_Rotated_Sorted_Array {
    /*  Idea: If a array has a monotonic space (i.e, it can be converted to a YYYYY...YN...NNNN or NNN...NY....YYYY), 
    *   then Binary Search can be applied on it. In our case, region is YYYY...YN...NNNN
    *   check() function is the function used to find a Yes/No answer wrt to an array element. Here
    *   we always check whether ith element is bigger or smaller to the first element of the array. Based on that and a few more conditions
    *   explained, we modify our binary search
    * 
    */
    public boolean check(int num,int val)
    {
        return val>=num;
    }
    public int search(int[] nums, int target) {
        
        int l = 0, r = nums.length-1; // Range limits of binary search
        boolean tarFlag = check(nums[0], target); // Stores whether the target lies in Y region or No region
        int ans = -1;
        while( l<=r )
        {
            int mid = l+(r-l)/2; // Finding mid value
            if(nums[mid]==target) // If the element matches target, we return the element.
                return mid;
            if(tarFlag) //If target lies in Y region
            {
                // Now our curr mid can be in a Y region or a N region
                if(check(nums[0], nums[mid])) // If mid element is in Y region,then mid can either be
                {                             // less than target or more than and hence, 
                                              // accordinly, we will update the ranges
                    if(nums[mid] > target) 
                        r = mid-1;
                    else
                        l = mid+1;
                }
                // target is in Y region and mid in N region means we need to check on left side
                else 
                    r = mid-1;
            }
            else
            {
                // Now our curr mid can be in a Y region or a N region
                // If mid element is in Y region,then mid can either be
                // less than target or more than and hence, 
                // accordinly, we will update the ranges
                if(!check(nums[0], nums[mid]))
                {
                    if(nums[mid] > target)
                        r = mid-1;
                    else
                        l = mid+1;
                }

                // target is in N region and mid in Y region means we need to check on right side
                else
                    l = mid+1;
            }
        }
        return ans;
    }
}