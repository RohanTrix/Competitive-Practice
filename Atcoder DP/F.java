import java.util.*;

public class F
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next(), t = in.next();
        //Finding length of LCS using DP
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for(int i=s.length() - 1; i>=0; i--) {
			for(int j=t.length() - 1; j>=0; j--) {
				if(s.charAt(i) == t.charAt(j)) {
					dp[i][j] = dp[i+1][j+1] + 1;
					continue;
				}
				dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
			}
		}

		for(int i=0,j=0; i<s.length() && j<t.length();) {
			if(s.charAt(i) == t.charAt(j)) // Whenever letter in both string is same, we move diagonally down
            {
				System.out.print(s.charAt(i));
				i++;
				j++; 
				continue;
			}
			if(dp[i][j] == dp[i+1][j]) i++; // If this is true, it means ith letter was not taken
			else j++; // Else jth letter was not taken
		}
	}
}