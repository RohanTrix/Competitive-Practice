/**
 *      IDEA : SEGMENT TREE AND BINARY SEARCH
 *             
 *             USAGE OF SEGMENT TREE : Get the highest occuring element along with its vote(Similar to that used in moore's voting algorithm)
 *                                     This is done since out of different elements...the majority element will always be the best choice
 *                                     if at all its occurence crosses the threshold. This basically means that out of possible candidates..majority
 *                                     element of the subarray will be the best consideration
 *             
 * 
 *             After finding the majority element, the problem reduces to finding the actual frequency of the majority element
 *             in the given subarray. If the freq crosses `threshold`, then we can return the majority element else -1.
 *             To solve that problem, we use Binary Search.
 *             USAGE OF BINARY SEARCH : LC(2080) Range Frequency Queries 
 */
class MajorityChecker {

    SegTree st;
    Map<Integer, List<Integer>> idxs;
    int n;
    public MajorityChecker(int[] arr) {
        idxs = new HashMap<>(); // num -> Sorted List of indexes where map occurs
        n = arr.length;
        st = new SegTree(arr);
        st.build(1, 0, n-1);
        for(int i = 0; i<n; i++)
            idxs.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
    }
    
    public int query(int left, int right, int threshold) {

        Node res = st.query(1, 0, n-1, left, right);
        // If res.val == 0 -> means no majority element was found in this range
        if(res.val == 0) return -1;
        int major = res.val;

        // Finding the range of indexes of the majority element which lie in the query interval [left, right]
        List<Integer> list = idxs.get(major);  
        int l,r;
        //Left Bound
        l = 0; r = list.size()-1;
        int leftInd = -1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(list.get(mid)>=left)
            {
                leftInd = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        
        //Right Bound
        l = 0; r = list.size()-1;
        int rightInd = -1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(list.get(mid)<=right)
            {
                rightInd = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        if(threshold<=rightInd-leftInd+1)
            return res.val;
        return -1;
    }
    private class Node // Segment Tree node
    {
        // Stores majority element and its vote(moore's vote)
        // NOTE : VOTE is not neccesarily equal to the actual frequency
        int val, vote;
        public Node(int val, int vote)
        {
            this.val = val;
            this.vote = vote;
        }
        public String toString()
        {
            return val+" "+vote;
        }
    }
    private class SegTree
    {
        Node tree[];
        int nums[];
        int n;
        public SegTree(int nums[])
        {
            n = nums.length;
            this.nums = nums;
            tree = new Node[4*n+5];
        }
        public Node mergeNodes(Node left, Node right) // To merge the answer of 2 nodes
        {
            // If both the left and right subarrays have same majority element,
            // then the the majority remains same and votes get added up
            if(left.val == right.val)
                return new Node(left.val, left.vote+right.vote);
            
            // If both majorities are UNEQUAL, then the one with higher vote becomes new majority
            // And the and the new vote will be the DIFFERENCE between the 2 votes. Since lesser no.
            // votes will cancel out itself from the larger votes.
            else if(left.vote> right.vote)
                return new Node(left.val, left.vote - right.vote);
            else
                return new Node(right.val, right.vote - left.vote);
        }
        public void build(int id, int l, int r)
        {
            if(l == r)
            {
                tree[id] = new Node(nums[l], 1);
                return;
            }
            int mid = (l+r)/2;
            build(2*id, l, mid);
            build(2*id+1, mid + 1, r);
            
            tree[id] = mergeNodes(tree[2*id], tree[2*id+1]);
            
        }
        public Node query(int id, int l, int r, int lquery, int rquery)
        {
            // System.out.println(l+" # "+r);
            if(lquery>r || rquery<l)
                return new Node(0,0);
            if(l>=lquery && r<=rquery)
                return tree[id];
            
            int mid = (l+r)/2;
            Node left = query(2*id, l, mid, lquery, rquery);
            Node right = query(2*id+1, mid+1, r, lquery, rquery);
            return mergeNodes(left, right);
        }
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */