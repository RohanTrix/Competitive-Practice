/*
        IDEA: 
        
        Since we are talking about all subarrays's min and max, Monostack or Monoqueue shoudld come to mind.
        Moreover, here we also need to reformulate our problem as:

                ans = Sum(all max values across all subarrays) - Sum(all min values across all subarrays)
        
        Now, the key observation here is on how we can use the results like:
            1) First Smaller to Left
            2) First Smaller to Right
            3) First Larger to Left
            4) First Smaller to Right

            that we get from a MonoStack

        For each ith element, by finding the 

            1) First smaller to left AND first smaller to right,
               we get to know that ith element is the smallest element 
               in any subarray including this ith element and extending anywhere before the 
               first smallest elements on both sides.
            
            2) First larger to left AND first larger to right,
               we get to know that ith element is the largest element
               in any subarray including this ith element and extending anywhere before the
               first larger elements on both sides.
            
            We can add/sub the element as max/min for (no. all these subarrays) times.. now by inpection
            the number of such subarrays is 

            |* * * * * i * * * |
            
            So no. of subarrays including i in this range is (5+1)*(3+1) ..which is the number of times 
            u need to add/sub nums[i] 
*/
public class Sum_of_Subarray_Ranges
{
    static class MonoStack
    {
        int nums[];
        long res;
        ArrayDeque<Integer> ds = new ArrayDeque<>();
        ArrayDeque<Integer> is = new ArrayDeque<>();
        int firstLargerToLeft[], firstLargerToRight[], firstSmallerToLeft[], firstSmallerToRight[];
        public MonoStack(int nums[])
        {
            int n = nums.length;
            this.nums = nums;
            firstSmallerToLeft = new int[n];
            firstSmallerToRight = new int[n];
            firstLargerToLeft = new int[n];
            firstLargerToRight = new int[n];
            Arrays.fill(firstSmallerToLeft, -1);
            Arrays.fill(firstSmallerToRight, -1);
            Arrays.fill(firstLargerToLeft, -1);
            Arrays.fill(firstLargerToRight, -1);
            
            res = buildStack();
        }
        public long buildStack()
        {
            int n = nums.length;
            long finAns = 0;
            
            // Calculating firstSmallerToRight and firstSmallerToLeft for all i
            for(int i = 0; i<n; i++)
            {
                while(!is.isEmpty() && nums[is.peek()] >= nums[i])
                    firstSmallerToRight[is.poll()] = i;
                if(!is.isEmpty())
                    firstSmallerToLeft[i] = is.peek();
                is.push(i);
            }
            
            // Calculating firstLargerToRight and firstLargerToLeft for all i
            for(int i = 0; i<n; i++)
            {
                while(!ds.isEmpty() && nums[ds.peek()] <= nums[i])
                    firstLargerToRight[ds.poll()] = i;
                if(!ds.isEmpty())
                    firstLargerToLeft[i] = ds.peek();
                ds.push(i);
            }

            for(int i = 0; i<n; i++)
            {

                // If -1, setting to proper index to ease calculation
                int sl = firstSmallerToLeft[i]==-1?-1:firstSmallerToLeft[i];
                int sr = firstSmallerToRight[i]==-1?n:firstSmallerToRight[i];
                int gl = firstLargerToLeft[i]==-1?-1:firstLargerToLeft[i];
                int gr = firstLargerToRight[i]==-1?n:firstLargerToRight[i];
                
                // Count of elements before first smaller element than i is found on either side
                long countLeftSmaller = (i-1-(sl+1)+1);
                long countRightSmaller = ((sr-1)-(i+1)+1);
                
                finAns-=(countLeftSmaller+1L)*(countRightSmaller+1L)*nums[i];
                
                // Count of elements before first greater element than i is found on either side
                long countLeftGreater = (i-1-(gl+1)+1);
                long countRightGreater = ((gr-1)-(i+1)+1);
                
                finAns+=(countLeftGreater+1L)*(countRightGreater+1L)*nums[i];
            }
            return finAns;
        }
    }
    public long subArrayRanges(int[] nums) {
        MonoStack m = new MonoStack(nums);
        return m.res;
    }
}