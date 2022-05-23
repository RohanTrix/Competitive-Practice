import java.util.stream.*;

/*
        IDEA : We need the longest subarray length. We have k replacements allowed. This tells us that we need
               to apply sliding window technique. We traverse on each element, increase its freq.
               Now, we want to make all the other characters equal to the max freq character. And we can
               only change upto k characters, so we need to shrink our window size till the no. of
               other characters becomes <=k. We can take the max length across all such windows that end at 'right'.
*/
public class Longest_Repeating_Character_Replacement
{
    public int characterReplacement(String str, int k) {
        char s[] = str.toCharArray();
        int freq[] = new int[26];
        int left = 0, maxi= 0;
        for(int right = 0; right<s.length; right++)
        {
            freq[s[right]-'A']++;
            int maxSame = IntStream.of(freq).max().getAsInt();
            int diff = right-left+1 - maxSame;
            while(left< right && diff>k)
            {
                freq[s[left++]-'A']--;
                maxSame = IntStream.of(freq).max().getAsInt();
                diff = right-left+1 - maxSame;
            }
            maxi = Math.max(maxi, right-left+1);
        }
        return maxi;
    }
}