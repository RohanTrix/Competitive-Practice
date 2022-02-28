/*
    IDEA : Whenever we have to count across all substrings which contain some particular character,
           we can use the (leftCnt + 1)*(rightCnt+1) trick.

           If leftCnt =  no. of elements left of i and rightCnt = no. of elements right of i,
           then count of all subarrays/subtrings passing containing ith element is
                
                    (leftCnt + 1)*(rightCnt + 1)

           So here, if we find a character is a vowel, we will just use the formula to find out the number
           of substrings that contain that vowel.

*/
public class Vowels_of_All_Substrings
{
    public long countVowels(String word) {
        String vowels = "aeiou";
        char str[] = word.toCharArray();
        int n = word.length();
        long left = 0, right = n-1, cnt = 0;
        for(int i = 0; i<n; i++)
        {
            if(vowels.contains(""+str[i]))
                cnt+=(left+1)*(right+1);
            left++; right--;
        }
        return cnt;
    }
}