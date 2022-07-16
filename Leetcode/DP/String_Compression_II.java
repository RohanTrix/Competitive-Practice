public class String_Compression_II {
    // REFER ALEX WICE STREAM : Interview Weekly 7 for Explanantion...more efficient DP exists,
    //                          runtime for thsi is too strict and this barely passes. Code taken from Discuss

    static int[][][][] memo = new int[100][101][100][26];
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k; j++)
                for (int z = 0; z < n; z++)
                    for (int l = 0; l < 26; l++)
                        memo[i][j][z][l] = -1;
        return best(s.toCharArray(), 0, k, 0, s.charAt(0), memo);
    }

    private int best(char[] s, int i, int k, int count, char prev, int[][][][] memo) {
        if (i == s.length)
            return countVal(count);
        else if (memo[i][k][count][prev - 'a'] != -1)
            return memo[i][k][count][prev - 'a'];
        // if we are unable to delete any more characters
        else if (k == 0) {
            int ans = 0;
            // if the current character is equal, increase counter and move forward
            if (s[i] == prev)
                ans = best(s, i + 1, k, count + 1, prev, memo);
            // else, add the run-length size for the previous character, restart counter,
            // move forward and
            // pass the current character as previous
            else
                ans = countVal(count) + best(s, i + 1, k, 1, s[i], memo);
            memo[i][k][count][prev - 'a'] = ans;
            return ans;
        }
        // if we are able to delete, choose the best between deleting the current
        // character or not
        else {
            int ans = 0;
            // if characters are equal, we may delete it, then we do not increase the
            // counter, decrease one available deletion and move forward.
            // else we do not delete it, then we increase the counter and move forward.
            // we choose the min between those two actions
            if (s[i] == prev)
                ans = Math.min(best(s, i + 1, k, count + 1, prev, memo), best(s, i + 1, k - 1, count, prev, memo));
            // if characters are different, we may delete the current, then do not count the
            // run-length yet, move forward, decrease one available deletion and keep the
            // previous character
            // else we do not delete it, add the run-length of the previous characer, move
            // forward and pass the current character as previous.
            // we choose the min between those two actions
            else
                ans = Math.min(countVal(count) + best(s, i + 1, k, 1, s[i], memo),
                        best(s, i + 1, k - 1, count, prev, memo));
            memo[i][k][count][prev - 'a'] = ans;
            return ans;
        }
    }

    private int countVal(int count) {
        if (count == 0)
            return 0;
        int dig = 1;
        if (count > 9)
            dig = 2;
        if (count > 99)
            dig = 3;
        return count == 1 ? 1 : (dig + 1);
    }
}