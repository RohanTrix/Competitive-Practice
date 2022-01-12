public class Palindrome_Partitioning_IV
{
    // Epxlained in OneNote
    public boolean isPalin[][]; // Checks if s[i...j] is palindrome or not
    public int dp[][]; // Stores if s[0..i] and s[i+1...j-1] and s[j..n-1] are palindrome
    public boolean checkPartitioning(String s) {
        buildPalinCheck(s); // Building isPalin

        dp = new int[s.length()][s.length()];
        for(int a[]:dp) Arrays.fill(a, -1);
        return isPossible(0, s.length()-1, s)==1?true:false;
    }
    public int isPossible(int i, int j, String s)
    {
        
        if(i==j) return 1;
        // If middle substring is only of 1 character, return answer.
        if(i+2==j) return isPalin[0][i]&&isPalin[i+1][j-1]&&isPalin[j][s.length()-1]?1:0;

        if(dp[i][j]!=-1) return dp[i][j];
        
        // Checking if the current 3 partitions are all palindromes
        boolean curr = isPalin[0][i] && isPalin[i+1][j-1] && isPalin[j][s.length()-1];
        

        // Check if possible to by increasing one char in left partion or right partition
        return dp[i][j] = curr || (isPossible(i+1,j,s)==1) || (isPossible(i, j-1, s)==1)?1:0;
    }
    public void buildPalinCheck(String str) // Saves whehter substring s[i..j] is palindrome or not
    {
        char s[] = str.toCharArray();
        int n = s.length;
        isPalin = new boolean[n][n];
        for(int p = 0; p<str.length(); p++)
        {
            for(int i = 0, j = p; j<n; i++, j++)
            {
                if(p<=1)isPalin[i][j] = s[i]==s[j]?true:false;
                else isPalin[i][j] = s[i]==s[j]&&isPalin[i+1][j-1];
            }
        }
    }
}