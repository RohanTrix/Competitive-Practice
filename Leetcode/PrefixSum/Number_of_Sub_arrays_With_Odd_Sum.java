/*
    IDEA : In a subarray counting problem, we either use sliding window technique or Prefix Sum + HashMap
           The idea here is going to be borrowed from a previous problem where we find subarrays with sum =0.
           
           But here, if our currSum is even, then only subtracting a oddSum prefix sum can give us a
           odd sum subarray. 
           Similarly, if our currSum is odd, then only subtracting a evenSum prefix sum can give us a 
           odd sum subarray.


           Hence, we keep a running currSum,
                1) If currSum is even, then we add the number of oddSum prefix sums that we have found till now
                   Also we increment count of evenSum prefix sums by 1
                2) If currSum is odd, then we add the number of evenSum prefix sums that we have found till now
                   Also we increment count of oddSum prefix sums by 1
*/
public class Number_of_Sub-arrays_With_Odd_Sum
{
    public int numOfSubarrays(int[] arr) {
        long mod = (int)1e9+7;
        long cnt = 0;
        int n = arr.length;
        int odds = 0, evens = 1;
        int currSum = 0;
        for(int i = 0; i<n; i++)
        {
            currSum+=arr[i];
            if(currSum%2==0)
            {
                evens++;
                cnt+=odds;
                cnt%=mod;
            }
            else
            {
                odds++;
                cnt+=evens;
                cnt%=mod;
            }
        }
        return (int)cnt;
        
    }
}