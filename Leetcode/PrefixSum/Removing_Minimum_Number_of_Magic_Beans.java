/*
    IDEA : We need to bring some elements down to a particular number and some elements down to 0.
           The good thing is, we dont need to try to check by bring down to each number.
           It always optimal to bring down highers numbers down to a particular low number from the array itself.

           We can sort the array to think better. Now, if we choose an element....for which..if we bring down
           elements after this ith number(higher or equal) to current element and bring down the elements 
           before it(lower or equal) to zero...then we get a certain number of operations....We just have to try each index
           in this way...and take the minimum number of operations.

           Now, since COST of bringing elements arr[0...i-1] down to zero is nothing but SUM(arr[0...i-1])
           and COST of bringing elements arr[i....n] down to arr[i] is:

                SUM(arr[j] - arr[i]) where j goes from i->n...This can be written as SUM(arr[i..n]) - len(arr[i...n]) * arr[i]

            To calcutate sums like these, best way is Prefix Sums
*/
public class Removing_Minimum_Number_of_Magic_Beans {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long pref[] = new long[n+1];
        for(int i =1; i<=n; i++)
            pref[i] = pref[i-1] + beans[i-1];
        long mini = Long.MAX_VALUE;
        for(int i = 1; i<=n; i++)
        {
            long leftCost = pref[i-1];
            long rightCost = (pref[n] - pref[i-1]) - 1L*(n-i+1)*beans[i-1];
            mini = Math.min(mini, leftCost+rightCost);
        }
        return mini;
    }
}
