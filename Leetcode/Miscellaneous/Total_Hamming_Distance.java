public class Total_Hamming_Distance {
    // Total hamming distance for all numbers is just the sum of hamming distance for each bit across all
    // pairs of numbers. For ith bit, if we know how many numbers have 1 in it, then the remaining must have 0 at ith bit.
    // Hence, each 0 differs with every 1.
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ones[] = new int[31]; // How many numbers have 1 in ith bit
        for(int num : nums)
        {
            for(int i = 0; i<31; i++)
            {
                if((num&(1<<i))!=0)
                    ones[i]++;
            }
        }
        int sum = 0;
        for(int i = 0; i<31;i++)
            sum+=ones[i]*(n-ones[i]); // Each pair of diff bits
        return sum;
    }
}
