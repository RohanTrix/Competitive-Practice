/*
    IDEA : The most important observation here is:
            When you remove an element, all elements to the left of current do shift and hence retain their original
            indexing. However, elements of the right to curr shift by one....which means all odd indices become even
            and all even indices become odd.

            So we can simply use prefix sum and suffix sum for both odd and even. To make our life simpler,
            I will precalculate suffix sum for odd indices and even indices.
            Now, when we remove the ith element, we check whether it is odd-indexed or even-indexed...and subtract
            that from the corredsponding suffix sum.
*/
public class Ways_to_Make_a_Fair_Array {
    public int waysToMakeFair(int[] nums) {
        int n =nums.length;
        
        int prefEven = 0, prefOdd = 0, suffEven = 0, suffOdd = 0;
        for(int i = 0; i<n; i++)
        {
            suffEven+=(i%2==0)?nums[i]:0; // Building suffix sum for even idxs
            suffOdd+=(i%2!=0)?nums[i]:0; // Building suffix sum for odd idxs
        }
        int cnt = 0;
        for(int i = 0; i<n; i++)
        {
            if(i%2==0) // If curr idx is even, remove from even suffix sum
                suffEven-=nums[i];
            else // If curr idx is odd, remove from odd suffix sum
                suffOdd-=nums[i];
            
            // Right odd elements have become even indexed
            // Right even elements have become odd indexed.
            if(suffEven+prefOdd == suffOdd+prefEven) 
                    cnt++;

            // Update prefix to include curr element for next query
            prefEven+=(i%2==0)?nums[i]:0;
            prefOdd+=(i%2!=0)?nums[i]:0;
        }
        return cnt;
    }
}
