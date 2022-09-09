/**
 *      IDEA : The question says that we need to find any such subarray which 
 *             has the property that all the elements in that subarray are > threshold / k. The gist of
 *             the above statement is that we need to find the subarray minimum and 
 *             we need to expand that subarray as max as possible so as to have
 *             as less (threshold / k) as possible.
 * 
 * 
 *             So lets try to make every ith element the minimum of a subarray. So by finding the 
 *             index of the first smaller element to the left and first smaller to the right of ith element,
 *             we know that the elements that occur in between these boundaries will be >= ith element.
 *             THIS means ith element is the minimum here. Now, for this subarray, we do not need to check
 *             the (threshold / k) condition for all elements....since if ith element(which is also the minimum)
 *             follows it, then all other elements will follow the same as they are GREATER or EQUAL to ith element.
 *             
 *             To find the 2 boundaries of ith element where it is the minimum, we just need to find the 
 *             nextSmaller to left and right. This can be precomputed in O(n) using a MonoStack.
 * 
 *             Hence, if for any i the condition satisfies....we return the length of the array.
 * 
 */
public class Subarray_With_Elements_Greater_Than_Varying_Threshold
{
    class MonoStack
    {
        int firstSmallerToLeft[], firstSmallerToRight[];
        public MonoStack(int nums[])
        {
            int n = nums.length;
            firstSmallerToLeft = new int[n];
            firstSmallerToRight = new int[n];
            Arrays.fill(firstSmallerToLeft, -1);
            Arrays.fill(firstSmallerToRight, n);
            buildInc(nums);
        }
        public void buildInc(int nums[])
        {
            int n = nums.length;
            Stack<Integer> st = new Stack<>();
            for(int i = 0; i<n; i++)
            {
                while(!st.isEmpty() && nums[st.peek()] > nums[i])
                    firstSmallerToRight[st.pop()] = i;
                if(!st.isEmpty())
                    firstSmallerToLeft[i] = st.peek();
                st.push(i);
            }
        }
    }
    public int validSubarraySize(int[] nums, int threshold) {
        MonoStack ms = new MonoStack(nums);
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            int len = ms.firstSmallerToRight[i] - ms.firstSmallerToLeft[i] - 1;
            if(1L*nums[i]*len > threshold)
                return len;
        }
        return -1;
    }
}