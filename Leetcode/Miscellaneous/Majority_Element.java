public class Majority_Element {
    // Implemented https://www.cs.utexas.edu/~moore/best-ideas/mjrty/
    
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int cnt = 0;
        for(int i : nums)
        {
            if(cnt==0)
            {
                cnt++;
                candidate = i;
            }
            else
            {
                if(candidate == i)
                    cnt++;
                else
                    cnt--;
            }
        }
        return candidate;
    }
}
