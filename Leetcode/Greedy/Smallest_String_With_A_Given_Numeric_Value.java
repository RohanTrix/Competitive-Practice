/*
    IDEA : At every position, we need to ask ourselves is whether we can put a letter or not.
           So, if not, we move to the next letter and check wheter that can be placed or not.

           Now.. the way we check that is that if we place a particular letter on the current position, then
           whether or not the remaining sum can be completed by placing largest chars like 'z' on the remaining positions.
           While not possible, we keep increasing the letter to be placed. 

*/

public class Smallest_String_With_A_Given_Numeric_Value
{
    public String getSmallestString(int n, int k) {
        int ch = 1;
        StringBuilder s = new StringBuilder();
        int sum = 0;
        for(int i = 1; i<=n; i++)
        {
            while(k-sum-ch > (n-i)*26)
                ch++;
            sum+=ch;
            s.append((char)(ch+'a'-1));
        }
        return s.toString();
    }
}