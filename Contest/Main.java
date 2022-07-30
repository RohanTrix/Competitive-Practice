import java.util.*;
public class Main
{
    public boolean check(int f1[], int f2[])
    {
        for(int i = 0; i<26; i++) if(f1[i]!=f2[i]) return false;
        return true;
    }
    public boolean isAnagram(String str, String ttr)
    {
        char s[] = str.toCharArray();
        char t[] = ttr.toCharArray();
        
        int freqT[] = new int[26];
        int freqS[] = new int[26];
        for(char ch : t) freqT[ch-'a']++;

        int slen = s.length, tlen = t.length;
        int left = 0;
        for(int right = 0; right<slen; right++)
        {
            
            freqS[s[right]-'a']++;
            if(right>=tlen)
            {
                freqS[s[left++]-'a']--;
            }
            if(right>=tlen-1)
            {
                if (check(freqS, freqT)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "abcdefg";
        String t = "dc";
        Main ob = new Main();
        if(ob.isAnagram(s, t))
            System.out.println("Substring is Anagram");
        else
            System.out.println("Substrng is NOT Anagram");

    }
}