/*
 *      IDEA : Think about the normal O(n^2) DP LIS. For finding the longest ending at current element,
 *             we would check all the previous best lengths that cud be extended. So basically for the ith element,
 *             you wanted MAX(dp[0..i-1] where arr[j] < arr[i])...but here we have a constraint that
 *             we can only have an extension from values between [arr[i] - k... arr[i] - 1]
 *             We use the segment tree for getting the best previous DP state.
 *             
 *             DP[val] = LIS length ending with value val
 *             
 *             So to calculate your ans for the current DP state... I will basicallyget the max from
 *             DP[val - k] --- DP[val - 1]...this MAX will be taken in log(k) due to SEGMENT tree.
 *             SO, DP[val] = 1 + MAX(DP[val - k] --- DP[val - 1])....TO SET THIS DP[VAL]...I will 
 *             basically call a SegTree Update. Here, BOTTOM UP DP is necessary...Follow the code to
 *             understand clearly
 * 
 */
public class Longest_Increasing_Subsequence_II {
    class SegTree
    {
        int tree[];
        int n;
        public SegTree(int n)
        {
            tree = new int[4*n+1];
        }
        // 1. Update
        // 2. Query
        
        public void update(int id, int l, int r, int pos, int val)
        {
            if(pos < l || r < pos) return;
            if(l == r)
            {
                tree[id] = val;
                return;
            }
            int mid = (l+r)/2;
            update(2*id, l, mid, pos, val);
            update(2*id+1, mid + 1, r, pos, val);
            tree[id] = Math.max(tree[2*id], tree[2*id+1]);
        }
        public int queryMax(int id, int l, int r, int lq, int rq)
        {
            if(r < lq || rq < l) return 0;
            if(lq <= l && r <= rq) return tree[id];
            
            int mid = (l+r)/2;
            int left = queryMax(2*id, l, mid, lq, rq);
            int right = queryMax(2*id+1, mid + 1, r, lq, rq);
            return Math.max(left, right);
        }
    }
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        int limit = (int)1e5;
        SegTree st = new SegTree(limit);
        
        for(int i = 0; i<n; i++)
        {
            int maxLen = 1 + st.queryMax(1,0,limit, nums[i] - k, nums[i] - 1);
            st.update(1, 0, limit, nums[i], maxLen);
        }
        return st.queryMax(1, 0, limit, 0, limit);
    }
}
