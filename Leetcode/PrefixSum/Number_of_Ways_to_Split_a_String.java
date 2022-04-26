/* 
    IDEA : Since we need to divide the string into 3 non-empty substrings that should have equal number of ones,
           we know that split is only possible if the count of 1s is divisible by 3.
           And if there are zero 1s, then we have to choose 2 gaps out of n-1 gaps to place the 2 dividers.
           
           Refer Here : https://www.files2link.ga/596855
           
           In the above image, we can see that after we get 2 ones, we can start placing the divider before the next 1. Similarly,
            after we get 4 ones, we can start placing the divider before next 1. To find these 2 period of 0s,
            doing a prefix sum on this string is a good option. The reason for that is that a binary string will result in a monotonic
            prefix sum. This means that we can find out the period where a number remains constant to be a period of 0s.

            And thus, using simple combinatorics, we can multiply the count of divider positions of either side to get our answer.
            

*/
public class Number_of_Ways_to_Split_a_String
{
    
    public int numWays(String str) {
        char s[] = str.toCharArray();
        int n = s.length, mod = (int) 1e9+7;
        long pref[] = new long[s.length+1];
        for(int i = 1; i<=n; i++)
            pref[i] = pref[i-1]+ (s[i-1] - '0');
        
        if(pref[n] == 0L)
        {
            return (int) (1L*(n-1)*(n-2)/2 %mod);
        }
        if(pref[n]%3 != 0) return 0;
        long cnt1 = 0, cnt2 = 0;
        long target = pref[n]/3;
        for(int i = 1; i<=n; i++)
        {
            if(pref[i] == target) cnt1++;
            if(pref[i] == 2*target) cnt2++;
        }
        return (int)(cnt1%mod*cnt2%mod)%mod;
        
    }
}