// REFER : https://youtu.be/wws9_2e_oDA
//         https://youtu.be/emzt0KnZ4Vw                                    

public class Strange_Printer
{
    Integer dp[][];
    public int turns(int i, int j, char s[])
    {
        
        if(i>j) return 0;
        if(i == j) return 1;
        if(dp[i][j]!=null) return dp[i][j];
        // System.out.println(i+" "+j);
        int cnt = 1 + turns(i+1, j, s); // Deleting ith char alone

        // Deleting ith char with some pth char if both are same
        for(int p = i+1; p<=j; p++)
        {
            if(s[i] == s[p])
                cnt = Math.min(cnt,turns(i+1,p,s) + turns(p+1,j,s));
        }
        return dp[i][j] = cnt;
    }
    public int strangePrinter(String s) {
        char str[] = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char ch : str)
            if(list.size() == 0 || list.get(list.size()-1)!=ch)
                list.add(ch);
        str = new char[list.size()];
        for(int i = 0; i<list.size(); i++)
            str[i] = list.get(i);
        // System.out.println(Arrays.toString(str));
        dp = new Integer[str.length][str.length];
        return turns(0, str.length-1, str);
    }
}