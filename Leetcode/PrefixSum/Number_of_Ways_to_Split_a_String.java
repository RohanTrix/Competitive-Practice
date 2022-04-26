public class Number_of_Ways_to_Split_a_String
{
    // IDEA : To be written
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