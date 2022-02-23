public class Find_K_th_Smallest_Pair_Distance {
    // REFER : https://youtu.be/veu_Q-da6ZY
    public int count(int mid, int nums[])
    {
        int left = 0, cnt = 0;
        for(int right = 1; right<nums.length; right++)
        {
            
            while(left<right && nums[right] - nums[left]>=mid)
                left++;
            
            cnt+= (right - left);
            
        }
        return cnt;
    }
    public int smallestDistancePair(int[] nums, int k) {
        
        
        Arrays.sort(nums);
        int l=  Integer.MAX_VALUE/2;
        for(int i = 1; i<nums.length; i++) l = Math.min(l, nums[i]-nums[i-1]);
        int r = nums[nums.length-1] - nums[0];
        int bestAns = r;
        while(l<=r)
        {
            int mid = l +(r - l)/2;
            int cnt = count(mid, nums);
            //System.out.println("mid = "+mid + "cnt = " +cnt);
            if(cnt < k)
            {
                l = mid + 1;
                bestAns = mid;
            }
            else
            {
                r = mid - 1;
                
            }
        }
        return bestAns;
    }
}
