package Leetcode.StringAlgo;

public class Longest_Happy_Prefix {
    public static int[] getLPS(String s)
    {
        int n = s.length();
        int lps[] = new int[n+1];
        int i = 0, j = -1;
        lps[0] = -1;
        while(i<n)
        {
            while(j!=-1 && s.charAt(j)!=s.charAt(i))
                j = lps[j];
            i++;
            j++;
            lps[i] = j;
        }
        return lps;
    }
    public String longestPrefix(String s) {
        int lps[] = getLPS(s);
        
        return s.substring(0,lps[s.length()]);
    }
}
