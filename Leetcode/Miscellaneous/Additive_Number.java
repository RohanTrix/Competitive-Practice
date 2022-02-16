/*
    IDEA : This is a crazy level backtracking ques(or maybe I am crazy).
           There are a lot of edge cases due to leading zero not allowed. 
           
           The basic idea is is to maintain the previous 2 numbers that were formed and check if the
           new number being formed is equal to the sum of the first two...If yes, then we can recur.
*/
public class Additive_Number {
    public boolean isSeq(int ind, int first, int second, char s[])
    {
        if(ind== s.length) return true; // Successfully formed a sequence
        boolean ans = false;
        int res = 0;
        if(s[ind] == '0') return first+second == 0; // If 0 is first digit...
                                                    // then only works if all digits before were 0 to give a 0 sum
        
        // Take each digit and check if it can be a sum of prev two, if yes....send the next recursion and OR its result
        for(int i = ind; i<s.length; i++)
        {
            res = res*10 + (s[i] - '0');
            if(res == first + second)
            {
                ans = ans || isSeq(i+1,second, res, s);
            }
        }
        return ans;
    }
    public boolean isAdditiveNumber(String num) {
        int first = 0;
        char s[] = num.toCharArray();
        boolean ans = false;
        if(num.length()<3) return false;
        // If first 2 elements are 0, everything following it should be 0
        if(s[0]== '0' && s[1] == '0') return num.chars().filter(ch->ch=='0').count()==s.length;
        // If only first element is 0, then we try to make a 2nd non-zero element
        if(s[0] == '0')
        {
            int second = 0;
            for(int i = 1; i<Math.min(12,s.length-2); i++) // looping max uptil 12 only as 3 max no.s can have length= (35/3) each
            {
                second = second*10 + (s[i]-'0');
                ans =  ans || isSeq(i+1, 0, second,s);
            }
            return ans;
        }
        // If first element is non-zero
        for(int i = 0; i<Math.min(12,s.length-2); i++) 
        {
            first = first*10 + (s[i]-'0');
            // If the second element in the seq is a 0, then we need to check if we can make a sequence after taking first and second=0
            if(s[i+1] == '0')
            {
                ans = ans|| isSeq(i+2,first, 0, s);
                continue;
            }
            int second = 0;
            // First and second both non-zero elements
            for(int j = i+1; j<s.length-1; j++)
            {
                second = second*10+(s[j]-'0');
                ans =  ans || isSeq(j+1, first, second, s);
            }
        }
        return ans;
    }
}
