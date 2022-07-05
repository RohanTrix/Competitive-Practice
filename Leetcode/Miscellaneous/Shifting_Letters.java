public class Shifting_Letters
{
    // shift for first let = total shift
    // shift for second let = total shift - (shift for 1 element only)
    // shift for third let = total shift - (shift for 1 element only) - (shift for 1st 2 elements only)
    // ...

    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long tot = 0;
        for(int num : shifts)
            tot+=num;
        char str[] = s.toCharArray();
        for(int i = 0; i<str.length; i++)
        {
            char ch = str[i];
            long rem = tot%26;
            str[i] = (char)((ch - 'a' + rem)%26 +'a'); //  Cyclic shift of a character in one line
            tot-=shifts[i];
        }
        return new String(str);
    }
}