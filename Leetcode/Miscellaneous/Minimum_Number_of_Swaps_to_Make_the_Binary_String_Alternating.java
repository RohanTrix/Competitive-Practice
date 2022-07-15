public class Minimum_Number_of_Swaps_to_Make_the_Binary_String_Alternating
{
    int Z,O;
    public int countWrong(int st, char s[])
    {
        // Find the no. of mismatching positions...because each piar will be swapped...so ans will be cnt/2
        int cnt = 0;
        for(char ch : s)
        {
            if((ch-'0') != st)cnt++;
            st^=1;
        }
        // It might happen that there are odd incorrect positions..its not possible to fix in that case
        // since we need to swap 2 incorrect positions to make 2 correct
        return (cnt%2==0?cnt/2:-1);
    }
    public int minSwaps(String s) {
        char str[] = s.toCharArray();
        for(char ch : str)
        {
            if(ch == '0')Z++;
            else O++;
        }
        if(Math.abs(Z-O)>1) return -1; // Abs Diff between cnt of 0s and cnt of 1s shud be <=1
        int zeroStart = countWrong(0,str); // Cost if we convert it into "01010101...." seq
        int oneStart = countWrong(1, str); // Cost if we convert it into "10101010...." seq
        if(oneStart == -1 && zeroStart == -1) return -1; 
        if(zeroStart == -1) zeroStart = oneStart ;
        else if(oneStart == -1) oneStart = zeroStart;
        return Math.min(zeroStart, oneStart);
    }
}