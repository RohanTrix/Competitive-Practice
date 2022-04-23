/*
    REFER : https://leetcode.com/problems/maximum-width-ramp/discuss/208659/Simple-java-solution-with-TreeMap
            https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
*/
public class Maximum_Width_Ramp // nlog n
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

class Maximum_Width_Ramp1 // Sorting by value + Prefix Min on indexes ---> nlog n
{
    public int maxWidthRamp(int[] nums) {
        List<int[]> pairs = new ArrayList<>();
        for(int i = 0; i<nums.length; i++)
            pairs.add(new int[]{nums[i], i});
        Collections.sort(pairs, (a,b) -> a[0] - b[0]);
        
        int prefMin[] = new int[nums.length];
        prefMin[0] = pairs.get(0)[1];
        int maxi = 0;
        for(int i = 1; i<pairs.size(); i++)
        {
            maxi = Math.max(maxi, Math.max(0, pairs.get(i)[1] - prefMin[i-1]));
            prefMin[i] = Math.min(prefMin[i-1], pairs.get(i)[1]);
        }
        return maxi;
        
    }
}