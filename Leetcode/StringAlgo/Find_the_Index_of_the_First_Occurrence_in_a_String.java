package Leetcode.StringAlgo;

public class Find_the_Index_of_the_First_Occurrence_in_a_String {
    // USE KMP : Finding substrings equal to `pat` in main string
    public static int[] getLPS(String s)
    {
        int n = s.length();
        int lps[] = new int[n+1];
        int i = 0, j = -1;
        lps[0] = -1;
        while(i<n)
        {
            while(j!=-1 && s.charAt(j)!=s.charAt(i)) j = lps[j];
            i++;j++;
            lps[i] = j;
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        String s = needle + '#' + haystack;
        int len = needle.length();
        int lps[] = getLPS(s);
        System.out.println(Arrays.toString(lps));
        for(int i = len+1; i<lps.length; i++)
            if(lps[i] == len)
                return i - 2*len - 1;
        return -1;
        
    }
}
