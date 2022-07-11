public class Maximum_of_Minimum_Values_in_All_Subarrays {
    int[] maxOfMin(int[] nums, int n) 
    {
        // REFER : https://youtu.be/yRagSKdQgsc AND https://youtu.be/CK8PIAF-m2E
        Stack<Integer> st = new Stack<>();
        int firstSmallerToLeft[] = new int[n], firstSmallerToRight[] = new int[n];
        Arrays.fill(firstSmallerToLeft,-1);
        Arrays.fill(firstSmallerToRight, n);
        for(int i = 0; i<n; i++)
        {
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
                firstSmallerToRight[st.pop()] = i;
            if(!st.isEmpty())
                firstSmallerToLeft[i] = st.peek();
            st.push(i);
        }
        
        int ans[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            int leftBound = firstSmallerToLeft[i];
            int rightBound = firstSmallerToRight[i];
            int subArrLen = (rightBound - 1) - (leftBound+1) + 1;
            ans[subArrLen-1] = Math.max(ans[subArrLen-1], nums[i]);
        }
        for(int i = n-2; i>=0; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);
            
        return ans;
    }
}
