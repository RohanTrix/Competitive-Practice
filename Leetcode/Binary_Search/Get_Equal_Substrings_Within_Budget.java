/**
 *      IDEA : Can also be solved using Variable Sliding Window
 * 
 * 
 */

public class Get_Equal_Substrings_Within_Budget {
    int maxCost;
    public boolean possible(int len, char s[], char t[])
    {
        int cost = 0;
        for(int right = 0; right<s.length; right++)
        {
            cost+=Math.abs(s[right] - t[right]);
            if(right>=len-1)
            {
                if(right>=len)
                    cost-=Math.abs(s[right-len] - t[right-len]);
                if(cost<=maxCost) return  true;
            }
        }
        return false;
    }
    public int equalSubstring(String str, String ttr, int maxCost) {
        int n = str.length();
        this.maxCost = maxCost;
        char s[] = str.toCharArray(), t[] = ttr.toCharArray();
        int l = 1, r = n;
        int ans = 0;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(possible(mid, s, t))
            {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
}
