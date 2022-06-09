package Leetcode.PrefixSum;

/*
     Soved in One Go :)
    IDEA : Here, since we are free to permute the nums array as we like, we want the highest number in nums to be queried the
           the most number of time, then second highest and so on. So the problem is about finding the ordering of the cells which
           are queried highest to lowest. Since there are a lot of range updates, we can use Partial Sums( Difference Array some
            call it). We do partial sums update on each request on the initially empty prefix array,
            and finally take a prefix sum of the whole prefix array. Now we basically have the freq of how many times a cell i was queried.
            We sort both the nums and prefix array in decreasing order and start multiplying corresponding prefix value with nums value.
            This will give us our answer.
*/
public class Maximum_Sum_Obtained_of_Any_Permutation {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int mod = (int) 1e9+7;
        Integer pref[] = new Integer[n+2];
        Arrays.fill(pref,0);
        for(int req[] : requests)
        {
            int x = req[0] + 1, y = req[1] + 1;
            pref[x]++;
            pref[y+1]--;
        }
        for(int i = 1; i<=n; i++)
            pref[i] += pref[i-1];
        Arrays.sort(pref, Collections.reverseOrder());

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        long sum = 0;
        for(int i = 0; i<n; i++)
        {
            sum+=(1L*pref[i]*list.get(i));
            sum%=mod;
        }
        return (int) sum;
    }
}
