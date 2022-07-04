public class Number_of_People_Aware_of_a_Secret {
    // REFER : https://youtu.be/dalyTgkiH0s
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n+1]; // dp[i] = No. of people who discover the secret on day i
        dp[1] = 1;
        int mod = (int)1e9+7;
        for(int i = 1; i<=n; i++)
        {
            for(int j = i+delay; j<Math.min(n+1,i+forget); j++)
            {
                dp[j]+=dp[i]; // The no. of people who discover the secret on day i...will tell it to other dp[i] people on day j
                dp[j]%=mod;
            }
        }
        long ans = 0;
        for(int i = n; i>Math.max(0,n-forget); i--)
        {
            ans+=dp[i];
            ans%=mod;
        }
        return (int)ans;
    }
}
