/**
 * IDEA : The only case when no operation we do can break palidrome property of str is when its length = 1.
 *        
 *        Obs 1 : Since its given as a palindrome, we only have to traverse uptil n/2.
 *        Obs 2 : Greedily thinking, to get the smallest lexicographically, we want to convert a letter which is more towards left
 *                and the letter to which we wanna convert it is as small as possible.
 *        Obs 3 : The smallest letter we can convert any letter to is 'a'...but we can only do this if a letter is not already 'a'.
 *        Obs 4 : We try to see if a letter can be changed to 'a' (it will break palin property on changing on letter)
 *        Obs 5 : If we cannot change any letter to 'a', this means the string was full of 'a'...like aaaaaaaa
 *                In this case, the next smallest str is the one just after this...aaaaaaab...Hence using the one operation we
 *                have, we change last char to 'b'.
 */

public class Break_a_Palindrome {
    public String breakPalindrome(String palindrome) {
        boolean used = false;
        char s[] = palindrome.toCharArray();
        for(int i = 0; i<palindrome.length()/2; i++)
        {
            if(s[i]>'a')
            {
                used = true;
                s[i] = 'a';
                break;
            }
        }
        if(!used) s[s.length-1] = 'b';
        return (s.length==1)?"":new String(s);
    }
}
