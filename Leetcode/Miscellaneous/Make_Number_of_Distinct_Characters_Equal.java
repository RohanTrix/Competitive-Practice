package Leetcode.Miscellaneous;

// IDEA : Brute Force on the 26 letters of both strings ....make  a change in the hashmaps of both and check if they are the same
//        Read code to understand better
public class Make_Number_of_Distinct_Characters_Equal {
    public int cnt(int f[])
    {
        int c = 0;
        for(int i = 0; i<26; i++)
            if(f[i]!=0)
                c++;
        return c;
            
    }
    public boolean isItPossible(String word1, String word2) {
        int f1[] = new int[26], f2[] = new int[26];
        for(char ch : word1.toCharArray())
            f1[ch-'a']++;
        for(char ch : word2.toCharArray())
            f2[ch-'a']++;
        for(int i = 0; i<26; i++)
            for(int j = 0; j<26; j++)
            {
                if( f1[i]==0 || f2[j] == 0) continue;
                f2[i]++;f1[j]++;
                f1[i]--;f2[j]--;
                if(cnt(f1) == cnt(f2)) return true;
                f2[i]--;f1[j]--;
                f1[i]++;f2[j]++;
            }
        return false;
        
    }
}
