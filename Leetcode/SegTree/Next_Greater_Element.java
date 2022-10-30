/**      SOLVED BY SELF :)
 *       o(n log^2(n))
 *       IDEA : Finding the index of the next greater element is a common MonoStack problem and hence that is the first step
 *              I do. After that, the problem becomes about find the first element (leftmost) after this nextGreater's index
 *              which can be solved by Binary Search + Segment Tree ( Similar to Walk on a Segment Tree Idea)
 *              
 *              Read code to understand.
 * 
 * 
 */

public class Next_Greater_Element {
    class SegTree
    {
        int nums[];
        int tree[];
        public SegTree(int nums[])
        {
            int n = nums.length;
            this.nums = nums;
            tree = new int[4*n + 5];
            build(1, 0 ,n-1);
        }
        public void build(int id, int l, int r)
        {
            if(l == r)
            {
                tree[id] = nums[l];
                return;
            }
            int mid = (l+r)/2;
            build(2*id, l, mid);
            build(2*id+1, mid + 1, r);
            tree[id] = Math.max(tree[2*id], tree[2*id+1]);
        }
        // Max of the Segment
        public int query(int id, int l, int r, int lquery, int rquery)
        {
            if(r<lquery || l>rquery)
                return -1;
            if(l>=lquery && r<=rquery)
                return tree[id];

            int mid = (l+r)/2;
            int left_ans = query(2*id, l, mid, lquery, rquery);
            int right_ans = query(2*id+1, mid+1, r, lquery, rquery);
            return Math.max(left_ans,right_ans);
        }
    }
    class MonoStack
    {
        int nums[], nextGreater[], n;
        public MonoStack(int nums[])
        {
            n = nums.length;
            this.nums = nums;
            nextGreater = new int[n];
            Arrays.fill(nextGreater, -1);
            build();
        }
        public void build()
        {
            Deque<Integer> st = new ArrayDeque<>();
            for(int i = 0; i<n; i++)
            {
                while(!st.isEmpty() && nums[st.peek()] < nums[i])
                    nextGreater[st.pop()] = i;
                st.push(i);
            }
        }
    }
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        MonoStack ms = new MonoStack(nums);
        SegTree st = new SegTree(nums);
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        for(int i = 0; i<n; i++)
        {
            int ngIndex = ms.nextGreater[i];
            if(ngIndex == -1) continue;
            int l = ngIndex+1, r = n-1;
            while(l<=r)
            {
                int mid = (l+r)/2;
                int leftMax = st.query(1, 0, n-1, l, mid);
                if(leftMax > nums[i])
                {
                    ans[i] = leftMax;
                    r = mid - 1;
                }
                else
                    l = mid + 1;
            }
        }
        return ans;
    }
}
