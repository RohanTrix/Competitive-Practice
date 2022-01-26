public class The_k-th_Lexicographical_String_of_All_Happy_Strings_of_Length_n {
    // Go for DFS in a way that creates sorted strings
    public List<String> res = new ArrayList<>();
    public void dfs(String curr,  int n, char prev)
    {
        if(n==0)
        {
            res.add(curr);
            return;
        }
        char arr[] = {'a','b','c'};
        for(int i =0; i<3; i++)
        {
            char ch = arr[i];
            if(ch==prev) continue;
            dfs(curr+ch, n-1, ch);
        }
    }
    public String getHappyString(int n, int k) {
        dfs("", n, '#');
        return (res.size()<k)?"":res.get(k-1);
    }
}
