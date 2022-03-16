/*
    IDEA : We want the leftmost index for a value at ith index to 
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