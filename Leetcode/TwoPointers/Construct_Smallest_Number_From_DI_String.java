package Leetcode.TwoPointers;

/*
 *      ** During contest, I did not read the question, only read the last line and went over the examples and ACed **
 *      
 *      IDEA : Firstly, for a pattern of length n, the answer will be on length n+1.
 *             Next, for the IIII... portion, we can simply incrementally put numbers like 1,2,3... and so on
 *             However, for a pattern like DDDDD...we actually want to start place continuous increasing no.s like 1,2,3 from behind
 *             So what I mean is for DDD, the pattern we want is 321 which is 1,2,3 placed in reverse.
 *             So this hints towards finding the position where this DDD... seq ends...It can either end with a 'I' or the string gets over.
 *             Hence, from the end point to the current point on the left, we want to fill up incrementally(in reverse basically)
 * 
 *             This totally hints me towards keeping 2 Pointers. So for 'I', just put the next digit. But if 'D' is encountered,
 *             traverse upto the last 'D' and fill these backwards
 * 
 * 
 *             One base case is : If there is a 'I' at the end...then we also have to encorporate that separately since string
 *                                is of length n+1
 */

public class Construct_Smallest_Number_From_DI_String {
    public String smallestNumber(String pattern) {
        char pat[] = pattern.toCharArray();
        int n = pat.length;
        char ans[] = new char[pat.length+1];
        int right = 0, left = 0;
        char v = '1';
        while(left<n)
        {
            if(pat[left] == 'I')
            {
                ans[left] = v++;
                left++;
            }
            else
            {
                right = left;
                while(right<n && pat[right]=='D')
                    right++;
                int sto = right+1;
                for(int i = right; i>=left; i--)
                    ans[i] = v++;
                left = sto;
            }
        }
        if(pat[n-1] == 'I') ans[n] = v;
        return new String(ans);
    }
}
