public class Shuffle_an_Array
{
    // Fisher-Yates Shuffle Algorithm
    int orig[];
    Random rand;
    public Solution(int[] nums) {
        this.orig = nums;
        rand = new Random();
    }
    public int[] reset() {
        return orig;
    }
    public int[] shuffle() {
        int nums[] = orig.clone();
        for(int i = orig.length-1; i>=1; i--)
        {
            int j = rand.nextInt(i+1);
            
            // Swapping elements
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        return nums;
    }
}