/*
    IDEA : Implementation type + two pointer idea.

           Use start a left from 0 and right from n-1.
           If chars match, we can move skip both indexes. If they do not match, we start another pointer from
           right and try to find the character that does not match. Then we have manually swap and during swapping
           count the number the no. of swaps made toi bring it to the right pointer.
*/
public class Minimum_Number_of_Moves_to_Make_Palindrome {
    public int minMovesToMakePalindrome(String s) {
        char str[] = s.toCharArray();
        int n = s.length();
        int left = 0;
        int right = n-1;
        int cnt = 0;
        while(left<right)
        {
            if(str[left] != str[right])
            {
                int pos = right;
                while(left < pos && str[left] !=str[pos])
                    pos--;
                if(left == pos)
                {
                    char tmp = str[pos];
                    str[pos] = str[pos+1];
                    str[pos+1] = tmp;
                    cnt++;
                }
                else
                {
                    while(pos < right)
                    {
                        char tmp = str[pos];
                        str[pos] = str[pos+1];
                        str[pos+1] = tmp;
                        cnt++;pos++;
                        
                    }
                    left++; right--;
                }
            }
            else
            {
                left++; right--;
            }
        }
        return cnt;
    }
}
