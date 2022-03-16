/*
    REFER : https://leetcode.com/problems/maximum-width-ramp/discuss/208659/Simple-java-solution-with-TreeMap
            https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
*/
public class Maximum_Width_Ramp
{

    public int maxWidthRamp(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int maxi = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(map.isEmpty() || nums[i] < map.firstKey())
            {
                map.put(nums[i], i);
            }
            else
            {
                // Key taken based on largest less than equal to(lower_bound binary search)
                int ind = map.floorEntry(nums[i]).getValue();
                maxi = Math.max(maxi, i - ind);
                
            }
        }
        return maxi;
    }
}