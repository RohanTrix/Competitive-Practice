public class Maximum_Product_After_K_Increments {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int mod = (int) 1e9+7;
        for(int num : nums) pq.add(num);
        while(k>0)
        {
            pq.add((pq.poll()+1)%mod);
            k--;
        }
        long res = 1L;
        while(!pq.isEmpty())
        {
            res*=pq.poll();
            res%=mod;
        }
        return (int)res;
    }
}
