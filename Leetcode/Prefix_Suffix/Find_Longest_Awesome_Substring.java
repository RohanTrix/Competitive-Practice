/**
 *      IDEA : We want subarray/substring, so we can think of a prefix frequency approach.
 * 
 *             Okay...back to basics first...to make a palindrome, we need all letters to occur an even number
 *             of times or exactly one letter to occur odd number of times. Since its either odd or even..
 *             we can think about using a bitmask to represent the PREFIX FREQUENCY of the letters(prefix freq)
 *             
 *             Thus...if we keep a running bitmask where even occurence is denoted by 0 bit and 1 occurence is
 *             denoted by 1 bit.....then we have 2 cases of finding a previous prefix
 * 
 *                  a) All letters occur even number of times in palindrome:
 *                      
 *                      We basically need to find the j where bitmask = current mask
 *                      because string [j+1..i] will have equal occurence for each digit
 *                  
 *                  b) All letters occur even number of times EXCEPT one letter:
 *                      
 *                      Here...if our prefix has a odd count for a letter...then we want to find the same prefix
 *                      but with even count for the same letter because ODD - EVEN = ODD
 * 
 *                      Similarly, EVEN - ODD = ODD
 * 
 *                      So in short, we want to find the opposite occurence(odd <-> even) for each character
 *                      in our prefix HashMap
 * 
 *              Now...to get the longest string...we only want to store the first occurence of every previous 
 *              prefix
 */
public class Find_Longest_Awesome_Substring {
    public int longestAwesome(String s) {
        // One go AC after checking tags :) :)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mask = 0;
        int maxLen = 0;
        for(int i = 0; i<s.length(); i++)
        {
            char ch =  s.charAt(i);
            mask^=(1<<(ch-'0'));
            for(int j = 0; j<10; j++)
            {
                if(map.containsKey(mask^(1<<j)))
                    maxLen = Math.max(maxLen, i - map.get(mask^(1<<j)));
            }
            if(map.containsKey(mask))
                maxLen = Math.max(maxLen, i - map.get(mask));
            else
                map.put(mask, i);
        }
        return maxLen;
    }
}
