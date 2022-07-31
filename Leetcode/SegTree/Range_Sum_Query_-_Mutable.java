 /**
  * Your NumArray object will be instantiated and called as such:
  * NumArray obj = new NumArray(nums);
  * obj.update(index,val);
  * int param_2 = obj.sumRange(left,right);
  */
class NumArray { // Segment Tree
    // CP AlgoZenith 
    int n;
    int tree[] = new int[400400];
    public NumArray(int[] nums) {
        n = nums.length;
        buildTree(1,0,n-1,nums);
        
    }
    public void buildTree(int index, int l, int r, int arr[])
    {
        if(l == r)
        {
            tree[index] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        buildTree(2*index, l, mid, arr);
        buildTree(2*index+1, mid + 1, r, arr);
        tree[index] = tree[2*index] + tree[2*index + 1];
    }
    
    public void update_helper(int index, int l, int r, int pos, int val)
    {
        if(pos<l || pos>r) return;
        if(l == r)
        {
            tree[index] = val;
            return;
        }
        int mid = (l+r)/2;
        update_helper(2*index, l, mid, pos, val);
        update_helper(2*index+1 , mid+1, r, pos,val);
        tree[index] = tree[2*index]+tree[2*index+1];
        
    }
    public void update(int pos, int val) {
        update_helper(1, 0, n-1, pos, val);

    }
    
    public int sumRange_helper(int index, int l, int r, int lquery, int rquery)
    {
        if(l>rquery || lquery>r) return 0;
        if(lquery<=l && r<=rquery) return tree[index];
        
        int mid = (l+r)/2;
        int leftAns = sumRange_helper(2*index, l, mid, lquery, rquery);
        int rightAns = sumRange_helper(2*index+1, mid+1, r, lquery, rquery);
        return leftAns+rightAns;
    }
    public int sumRange(int left, int right) {
        int val = sumRange_helper(1,0,n-1,left,right);

        return val;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */