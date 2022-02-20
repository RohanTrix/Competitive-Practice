
/*
    2 IDEAS : 
        1) Maintain a Prefix Min array and a Suffix Max Array. Then we just fix the mid element of the triplet
            every time, and check if min before this (using leftMin) is smaller than current and  max after(using
            rightMax) is larger than this...then we return true.
           
        2) We can use Monotonic Stack to get first smaller to left and first Larger to right. 
*/

class Solution {

    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        int leftMin[] = new int[n];
        int rightMax[] = new int[n];
        leftMin[0] = nums[0];
        rightMax[n-1] = nums[n-1];
        for(int i =1;i<n;i++)
        {
            leftMin[i] = Math.min(leftMin[i-1],nums[i]);
        }
        for(int i = n-2;i>=0;i--)
        {
            rightMax[i] = Math.max(rightMax[i+1],nums[i]);
        }

        for(int i = 0;i<n;i++)
        {
            if(leftMin[i]<nums[i] && rightMax[i]>nums[i])
                return true;
        }
        return false;
        
    }
}
class Solution1
{
    static class MonoStack
    {
        int nums[];
        Integer firstSmallerToLeft[], firstLargerToRight[];
        public MonoStack(int nums[])
        {
            this.nums = nums;
            this.firstSmallerToLeft = new Integer[nums.length];
            this.firstLargerToRight = new Integer[nums.length];
            // Arrays.fill(firstSmallerToLeft, Integer.MIN_VALUE);
            // Arrays.fill(firstLargerToRight, Integer.MIN_VALUE);
            buildIncreasingStack();
            buildDecreasingStack();
            
        }
        private void buildIncreasingStack() {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (nums[stack.peek()] >= nums[i])) {
                stack.poll();
            }
            if (!stack.isEmpty()) {
                firstSmallerToLeft[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
    }

    private void buildDecreasingStack() {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (nums[stack.peek()] < nums[i])) {
                firstLargerToRight[stack.poll()] = nums[i];
            }
            stack.push(i);
        }
    }
    }
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        MonoStack st = new MonoStack(nums);
        for(int i = 0; i<nums.length; i++)
        {
            if(st.firstSmallerToLeft[i]!=null && st.firstLargerToRight[i]!=null)
                return true;
        }
        return false;
        
    }
}