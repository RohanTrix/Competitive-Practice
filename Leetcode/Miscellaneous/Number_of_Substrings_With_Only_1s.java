/* IDEA:
    The fact that for a string s which has total N substrings....
    If we append a character `ch` to s, then substrings ending at `ch` will be
    (N+1).
    So if we encounter a '1', we add the previous continuous ones seen + 1 
    to the final answer.

*/

public class Number_of_Substrings_With_Only_1s {
    public int numSub(String s) {
        int fin = 0, prev = 0;
        char[] str = s.toCharArray();
        int mod = 1_000_000_007;
        for(int i = 0; i<s.length(); i++)
        {
            if(str[i]=='0') // Reset prev to 0 as trailing ones have broken
            {
                prev = 0;
                continue;
            }
            prev++; // Subtrings made of only '1's ending at at ith char 
            
            fin=(fin+prev)%mod; // Adding these many substrings to final answer
        }
        return fin%mod;
    }
}
