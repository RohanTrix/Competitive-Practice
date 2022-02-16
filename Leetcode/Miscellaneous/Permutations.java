/*
    IDEA : Try to put every element at curr index...and send for recursion and remember
           to only add those elements which have not been taken yet. Since all elements are unique,
           we can check whether or not a element has already beem included in the answer.
*/
public class Permutations {
    List<List<Integer>> ans = new ArrayList<>();
    public void permutation(int i, int nums[], List<Integer> currList)
    {
        if(i == nums.length)
        {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for(int ind = 0; ind<nums.length; ind++)
        {
            if(currList.contains(nums[ind]))continue; // Max 6 elements possible so O(n) check is negligible
            currList.add(nums[ind]);
            permutation(i + 1, nums, currList);
            currList.remove(currList.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permutation(0, nums, new ArrayList<>());
        return ans;
    }
}
