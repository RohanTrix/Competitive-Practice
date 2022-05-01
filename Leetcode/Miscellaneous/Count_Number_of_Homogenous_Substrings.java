public class Count_Number_of_Homogenous_Substrings
{
    // Count consecutive characters and cnt*(cnt+1)/2 (total substrings formed) to the answer
    public int countHomogenous(String s) {
        long cnt = 0, mod = (int)1e9+7;
        char prev = '\0';
        long res = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == prev) cnt++;
            else
            {
                res+=(cnt*(cnt+1))/2;
                res%=mod;
                prev = ch;
                cnt = 1;
            }
        }
        res+=(cnt*(cnt+1))/2;
        res%=mod;
        return (int) res;
    }
}