package Leetcode.StringAlgo;

public class Shortest_Palindrome {
    public int[] getLPS(String s)
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
    public String shortestPalindrome(String str) {
        StringBuilder copy = new StringBuilder(str);
        StringBuilder s  = new StringBuilder(str);
        
        s.reverse();
        str += "#" + s.toString();
        int lps[] = getLPS(str);
        //System.out.println(str);
        
        int n = lps[s.length()*2 + 1];
        
        for(; n<copy.length(); n++)
        {
            s.append(copy.charAt(n));
        }
        return s.reverse().toString();
        
    }
}
