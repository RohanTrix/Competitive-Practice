/**
 * n*logn approach, O(n) to be done using monostack
 * IDEA : Firstly, keeping a prefMin and suffixMin would not work, for a case like [3,5,0,3,4]. 
 *        So, first observation is to fix the central element every time. Also, we want our left element
 *        to be the smallest of the 3, so taking prefixMin is helpful.
 *        
 *        Now, we wat to find an element to the right of middle element, which is the largest element
 *        smaller than middle. For this, we use a TreeMap where elements and their frequencies are stored.
 */
public class 132_Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int prefMin[] = new int[n];
        prefMin[0] = nums[0];

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i = 1; i<n; i++)
            prefMin[i] = Math.min(prefMin[i-1], nums[i]);
        for(int i = n-1; i>1; i--)
            tm.put(nums[i], tm.getOrDefault(nums[i], 0)+1);
        
        for(int j = 1; j<n-1; j++)
        {
            Integer justless = tm.lowerKey(nums[j]);
            if(justless!=null && justless>prefMin[j-1])
                return true;
            
            tm.put(nums[j+1],tm.get(nums[j+1]) - 1);
            if(tm.get(nums[j+1]) == 0) tm.remove(nums[j+1]);
        }
        return false;
    }
}
