public class Sliding_Window_Median {
    // Similar Logic to Find Median from Data Stream but instead of a MAX PQ and MIN PQ
    // I use 2 TreeSet of pairs([nums[i],i]). 
    // Refer : https://youtu.be/kyuTzLT-rY4
    TreeSet<Pair> left = new TreeSet<>();
    TreeSet<Pair> right = new TreeSet<>();
    public double calcMedian(int k)
    {
        if(k%2 == 0)
            return (1.0*left.last().val+1.0*right.first().val)/2;
        else
            return left.last().val;
    }
    public void balance()
    {
        while(right.size()>left.size())
            left.add(right.pollFirst());
        while(left.size()>right.size()+1)
            right.add(left.pollLast());
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double ans[] = new double[n-k+1];
        for(int i = 0; i<k; i++)
            right.add(new Pair(nums[i], i));
        balance();
        ans[0] = calcMedian(k);
        for(int i = k; i<n; i++)
        {
            // Remove left boundary
            left.remove(new Pair(nums[i-k], i-k));
            right.remove(new Pair(nums[i-k], i-k));
            
            balance();
            
            // Add right boundary
            if((left.size() == 0 && right.size() == 0) || left.last().val>nums[i])
                left.add(new Pair(nums[i],i));
            else
                right.add(new Pair(nums[i], i));
            
            balance();
            
            ans[i-k+1] = calcMedian(k);
        }
        return ans;
    }
    class Pair implements Comparable<Pair>
    {
        int val, ind;
        public Pair(int val, int ind)
        {
            this.val = val;
            this.ind = ind;
        }
        public int compareTo(Pair p)
        {
            if(val==p.val)
                return ind - p.ind;
            return Integer.compare(val, p.val);
        }
        public boolean equals(Object o)
        {
            Pair p = (Pair) o;
            return val == p.val && ind == p.ind;
        }
        public int hashCode()
        {
            return Objects.hash(val, ind);
        }
    }
}
