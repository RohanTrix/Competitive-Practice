public class Number_of_Substrings_Containing_All_Three_Characters
{
    // REFER : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/723408/Sliding-Window-with-explanation-and-very-readable-with-comments
    public int numberOfSubstrings(String str) {
        char s[] = str.toCharArray();
        int freq[] = new int[3];
        int left = 0, n = s.length, cnt = 0;
        for(int right = 0; right<n; right++)
        {
            freq[s[right]-'a']++;
            while(left<right && freq[0]>0 && freq[1]>0 && freq[2]>0)
            {
                freq[s[left++]-'a']--;
            }
            cnt+=left;
        }
        return cnt;
    }
}