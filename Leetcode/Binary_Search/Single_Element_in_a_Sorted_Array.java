/**
 *      IDEA : Quite tricky with edge cases.
 *             
 *             First imagine an array of only elements occuring twice.
 *             
 *             Ex : [1,1,2,2,6,6,8,8]
                     0 1 2 3 4 5 6 7   - idxs

               From the above example, it is clear that the FIRST occurence will have an EVEN IDX and the
               SECOND occurence will have a ODD idx. Now lets see what happens if we add a number in between.
               
               Ex : [1,1,2,2,5,6,6,8,8]
                     0 1 2 3 4 5 6 7,8   - idxs

                  E-O order  |  O-E order

              After adding this single element, all elements after this element
              get their indices shifted by one. Hence the EVEN-ODD order for elements after single element
              become ODD-EVEN order.
              THIS IS THE BINARY SEARCHABLE PROPERTY that we can use.
*/
public class Single_Element_in_a_Sorted_Array
{
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0]; // Edge case for n=1
        
        int left = 0, right = n-1;
        int ans = -1;
        while(left <=right)
        {
            int mid = left + (right - left)/2;
            if(mid == 0 && nums[0] != nums[1]) // Edge case when first element is the single element
                return nums[0];
            if(mid == n-1 && nums[n-1] != nums[n-2]) // Edge case when last element is the single element
                return nums[n-1];
            if(mid%2 == 0) // If the index is a even index
            {
                if(nums[mid] == nums[mid + 1]) // If this is true, then we are in the E-O order
                                               // which means the single element has not come in arr[left...mid]
                    left = mid + 1;
                else                           // Else, then we are in the O-E order
                                               // which means the single element has come in arr[left...mid]
                {
                    ans = mid;
                    right = mid - 1;
                }
            }
            else                   // Similar logic as above, just the case is we land on a ODD idx
            {
                if(nums[mid] == nums[mid - 1])
                    left = mid + 1;
                else
                {
                    ans = mid;
                    right = mid - 1;
                }
            }
        }
        return nums[ans];
    }
}