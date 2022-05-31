/**
 * APPROACH 1 : Since we only care about the occurence of a letter and not its count, we can use
 *              a bitmask. We can make a prefix and a suffix array containing bitmasks of the chars.
 *              Finally, at each partition, we just check the prefix and suffix bitmask's no. of set bits.
 *              If they are equal, we increment our cnt.
 *              
 *              T.C => O(26*n) in worst case....counting set bits is a fast operation though
 *              S.C => O(n)
 * 
 * APPROACH 2 : Instead of bitmasks, we can keep a 26 sized array for prefix and suffix. As we traverse, we update
 *              the prefFreq and suffFreq[] array. And every time, in O(26) we can check how many unique chars
 *              on each side.
 *              
 *              T.C => O(26*n)
 *              S.C => O(26)
 */
class Number_of_Good_Ways_to_Split_a_String1 {
    public int count(int n)
    {
        int cnt = 0;
        while(n!=0)
        {
            n = n&(n-1);
            cnt++;
        }
        return cnt;
    }
    public int numSplits(String s) {
        int cnt = 0;
        int mask = 0, n = s.length();
        int suff[] = new int[s.length()];
        suff[n-1] = 1<<(s.charAt(n-1)-1);
        for(int i = s.length()-2; i>=0; i--)
            suff[i] = suff[i+1]|(1<<(s.charAt(i)-'a'));
        mask = 0;
        for(int i = 0; i<n-1; i++)
        {
            mask|=(1<<(s.charAt(i)-'a'));
            cnt+=(count(mask) == count(suff[i+1]))?1:0;
        }
        return cnt;
    }
}
public class Number_of_Good_Ways_to_Split_a_String {
    public int numSplits(String s) {
        int prefFreq[] = new int[26], suffFreq[] = new int[26];
        int n = s.length();
        int cnt = 0;
        char str[] = s.toCharArray();
        for(char ch : str)
            suffFreq[ch-'a']++;
        for(char ch : str)
        {
            prefFreq[ch-'a']++;
            suffFreq[ch-'a']--;
            int c1 = 0, c2 = 0;
            for(int i = 0; i<26; i++)
            {
                if(prefFreq[i]>0)c1++;
                if(suffFreq[i]>0)c2++;
            }
            if(c1 == c2)
                cnt++;
        }
        return cnt;
    }
}