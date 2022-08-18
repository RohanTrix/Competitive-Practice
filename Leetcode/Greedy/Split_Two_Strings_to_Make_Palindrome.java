public class Split_Two_Strings_to_Make_Palindrome
{
    // IDEA : Refer OneNote(Greedy Section) for Explanation

    public boolean isPalin(char s[], int i, int j) // Substring is palin or not check
    {
        while(i<=j)
        {
            if(s[i] != s[j]) return false;
            i++; j--;
        }
        return true;
    }
    
    // Checks if s1[0..i] + s2[i+1...n-1] is a Palindrome or not for some i 
    public boolean splitable(char s1[], char s2[])
    {
        int n = s1.length;
        if(isPalin(s1, 0, n-1) || isPalin(s2, 0, n-1)) return true; // If either string is a palindrome, then no issues taking a empty prefix/suffix
        
        int i = 0, j = n-1;
        while(i<=j) // Handles Case 2 in OneNote
        {
            if(s1[i] != s2[j]) // If there is a mismatch then we want either s1[i..j] or s2[i...j] to be a palindrome
                return isPalin(s1,i, j) || isPalin(s2, i, j);
            i++;
            j--;
        }

        return true; // Case 1 in OneNote
    }
    public boolean checkPalindromeFormation(String a, String b) {
        char A[] = a.toCharArray();
        char B[] = b.toCharArray();
        
        return splitable(A,B) || splitable(B,A);
    }
}