public class Sum_of_Subarray_Minimums {
    // Problem is a absolute subset of Sum of Subarray Ranges,
    // logic explained there. Solve that, this is half of it
    static class MonoStack
    {
        int mod = (int)1e9 + 7;
        int nums[], firstSmallerToLeft[], firstSmallerToRight[];
        public MonoStack(int nums[])
        {
            int n = nums.length;
            this.nums = nums;
            firstSmallerToLeft = new int[n];
            firstSmallerToRight = new int[n];
            Arrays.fill(firstSmallerToLeft, -1);
            Arrays.fill(firstSmallerToRight, -1);
        }
        public int buildStack()
        {
            int n = nums.length;
            long finAns = 0;
            Deque<Integer> s = new ArrayDeque<>();
            for(int i = 0; i<n; i++)
            {
                while(!s.isEmpty() && nums[s.peekLast()] >= nums[i])
                    firstSmallerToRight[s.pollLast()] = i;
                if(!s.isEmpty())
                    firstSmallerToLeft[i] = s.peekLast();
                s.offerLast(i);
            }
            
            for(int i = 0; i<n; i++)
            {
                int sl = firstSmallerToLeft[i]==-1?-1:firstSmallerToLeft[i];
                int sr = firstSmallerToRight[i]==-1?n:firstSmallerToRight[i];
                
                long countLeftSmaller = (i-1-(sl+1)+1);
                long countRightSmaller = ((sr-1)-(i+1)+1);
                
                finAns+=(countLeftSmaller+1L)*(countRightSmaller+1L)*nums[i];
                finAns%=mod;
                
            }
            return (int) finAns;
        }
    }
    public int sumSubarrayMins(int[] arr) {
        MonoStack m = new MonoStack(arr);
        return m.buildStack();
    }
}
