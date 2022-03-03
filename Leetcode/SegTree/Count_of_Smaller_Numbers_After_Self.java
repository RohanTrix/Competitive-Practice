
// IDEA : Explained in OneNote

public class Count_of_Smaller_Numbers_After_Self {
    int tree[], countArr[];
    public List<Integer> countSmaller(int[] nums) {
        
        // Coordinate Compression START
        List<Integer> list = new ArrayList<>();
        for(int i : nums) list.add(i);
        Collections.sort(list);
        Map<Integer, Integer> compressed = new HashMap<>();
        int compVal = 0, last = list.get(0);
        for(int i = 0; i<list.size(); i++) 
        {
            if(list.get(i)!=last) compVal++;
            compressed.put(list.get(i), compVal);
            last = list.get(i);
        }
        countArr = new int[compVal+1];
        for(int i = 0; i<nums.length; i++) nums[i] = compressed.get(nums[i]);
        // Coordinate Compression END
        
        
        
        tree = new int[4*nums.length+5];
        int ans[] = new int[nums.length];
        for(int i = nums.length-1; i>=0; i--)
        {
            // System.out.println(Arrays.toString(tree));
            ans[i] = query(1,0,compVal, 0, nums[i]-1);
            update(1,0,compVal, nums[i]);
            // System.out.println(Arrays.toString(tree)+"\n");
        }
        List<Integer> res = new ArrayList<>();
        for(int i : ans) res.add(i);
        return res;
        
    }
    int query(int index, int l, int r, int lquery, int rquery)
    {
        if(l>rquery || lquery> r) return 0;
        if(lquery<=l && r<=rquery)
            return tree[index];
        
        int mid = l+(r-l)/2;
        int leftAns = query(2*index, l, mid, lquery, rquery);
        int rightAns = query(2*index+1, mid+1, r, lquery, rquery);
        return leftAns+rightAns;
    }
    void update(int index, int l, int r, int pos)
    {
        if(pos<l || pos>r) return;
        if(l == r)
        {
            tree[index]++;
            countArr[l]++;
            return;
        }
        int mid = l+(r-l)/2;
        update(2*index, l, mid, pos);
        update(2*index+1, mid + 1, r, pos);
        tree[index] = tree[2*index] + tree[2*index+1];
    }
}
