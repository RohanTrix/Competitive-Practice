public class Longest_String_Chain
{
    // IDEA : LIS Type
    public boolean convertible(String prev, String curr)
    {
        if(prev.length()+1!=curr.length()) return false;
        boolean used = false;
        int j = 0;
        for(int i = 0; i<prev.length(); i++)
        {
            if(prev.charAt(i)!=curr.charAt(j))
            {
                if(!used)
                {
                    used = true;
                    i--;
                }
                else
                    return false;
            }
            j++;
        }
        return true;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(convertible(words[j], words[i]))
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}