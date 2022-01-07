public class Execution_of_All_Suffix_Instructions_Staying_in_a_Grid {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char str[] = s.toCharArray();
        int sr = startPos[0], sc = startPos[1];
        int ans[] = new int[str.length];
        for(int i = 0; i<s.length(); i++)
        {
            int j = i;
            int nx = sr, ny = sc;
            while(j<str.length)
            {
                
                if(str[j]=='L') ny--;
                else if(str[j]=='R') ny++;
                else if(str[j] == 'U') nx--;
                else nx++;
                if(!(nx>=0&&nx<n&&ny>=0&&ny<n)) break;
                j++;
            }
            ans[i] = j-i;
        }
        return ans;
    }
}
