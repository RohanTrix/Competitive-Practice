public class Subsets
{
    List<List<Integer>> res = new ArrayList<>();
    public void makeSubset(int i, int nums[], List<Integer> curr)
    {
        if(i == nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        makeSubset(i+1, nums, curr);
        curr.add(nums[i]);
        makeSubset(i+1, nums, curr);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        makeSubset(0, nums, new ArrayList<>());
        return res;
    }
}