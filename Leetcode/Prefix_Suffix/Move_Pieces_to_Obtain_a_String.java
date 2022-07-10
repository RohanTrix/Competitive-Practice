public class Move_Pieces_to_Obtain_a_String {
    public boolean canChange(String start, String target) {
        // IDEA : Little tough to explain, but the idea is Run-Length Encoding
        // Once for R's from left to right...and for L's from right to left
        int currSum1 = 0, currSum2 = 0;
        char s[] = start.toCharArray(), e[] = target.toCharArray();
        int n = s.length;
        // Checking if the R's are valid
        for(int i = 0; i<n; i++)
        {
            if(s[i] == 'R')
                currSum1++;
            else if(s[i] == 'L')
                currSum1 = 0;
            if(e[i] == 'R')
                currSum2++;
            else if(e[i] == 'L')
                currSum2 = 0;
            if(currSum1<currSum2) return false;
        }
        currSum1 = 0; currSum2 = 0;
        for(int i = n-1; i>=0; i--)
        {
            if(s[i] == 'L')
                currSum1++;
            else if(s[i] == 'R')
                currSum1 = 0;
            if(e[i] == 'L')
                currSum2++;
            else if(e[i] == 'R')
                currSum2 = 0;
            if(currSum1<currSum2) return false;
        }
        return true;
    }
}
