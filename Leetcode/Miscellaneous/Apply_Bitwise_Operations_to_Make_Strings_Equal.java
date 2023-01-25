package Leetcode.Miscellaneous;

/**
 *      IDEA : We can convert the given operation into 4 simple operations:
 * 
 * 
 *                  1) 00 -> 00
 *                  2) 01 -> 11
 *                  3) 10 -> 11
 *                  4) 11 -> 01 or 10...based on what we want.
 * 
 * 
 *             We understand from here that we can
 *                  1) Increase no. of 1s by consuming 0s in s (op2 or op3)..if we have at least 1 1s in the string
 *                  2) Increase no. of 0s by consuming 1s in s (op4)..if we have at least 2 1s in the string
 *                  3) Shift a bit anywhere in string (ex : 01 -> 11 -> 10)
 * 
 *             So we cannot make s==t if (t has 0 1s and s has more than 0 1s) or vice versa
 * 
 */

public class Apply_Bitwise_Operations_to_Make_Strings_Equal {
    public boolean makeStringsEqual(String s, String t) {
        int s1 = 0, t1 = 0;
        for(char ch : s.toCharArray()) {
            if(ch != '0') s1++;
        }
        
        for(char ch : t.toCharArray()) {
            if(ch == '0') t1++;
        }
        if(t1 == 0) return s1==0;
        if(s1 == 0) return false;
        return true;
    }
}
