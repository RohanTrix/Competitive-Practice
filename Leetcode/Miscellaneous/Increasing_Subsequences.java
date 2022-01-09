
public class Increasing_Subsequences
{
    List<List<Integer>> res = new ArrayList<>(); // Stores final answer

    public void dfs(int i,List<Integer>curr, int nums[])
    {
        // If we have reached the dfs call, it means we have created a increasing sequence
        if(curr.size()>1)
            res.add(new ArrayList<>(curr));
        
        // The values we pick to be added to the list next should greater than the 
        // last value in current list. For first value, last value can be -200(tho not present in list)
        int last = curr.size()==0?-200:curr.get(curr.size()-1);
        
        Set<Integer> used = new HashSet<>(); // To avoid calling [4,7], [4,7]
        // We don't want 4 to call 2 or more 7's at different positions after it.
        // Otherwise it will cause duplicate calls
        // Note that 4 calling 7 and then 7 calling 7 to get [4,7,7] is valid

        // We add to the curr list our next element from nums[i...n]
        for(int p = i; p<nums.length; p++)
        {
            if(nums[p]<last) continue; // If value lesser than last value in list, skip
            
            // If 7 at some pos p has been called, no need to call 7 at pos p'
            if(used.contains(nums[p])) continue; 
            
            curr.add(nums[p]); // Add new value to list
            used.add(nums[p]); // Mark the value as used
            dfs(p+1, curr, nums); // Call dfs on sub array after pth element
            curr.remove(curr.size()-1); // Remove the newly added element for next dfs call
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, new ArrayList<>(), nums);
        return res;
    }
}