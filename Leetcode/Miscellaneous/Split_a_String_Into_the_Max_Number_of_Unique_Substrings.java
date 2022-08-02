public class Split_a_String_Into_the_Max_Number_of_Unique_Substrings {
    // Simple Backtracking
    int maxi;
    char s[];
    public void maxSplit(int i, Set<String> set)
    {
        if(i == s.length)
        {
            maxi = Math.max(maxi, set.size());
            return;
        }
        
        StringBuilder str = new StringBuilder();
        for(int p = i; p<s.length; p++)
        {
            str.append(s[p]);
            if(!set.contains(str.toString()))
            {
                set.add(str.toString());
                maxSplit(p+1, set);
                set.remove(str.toString());
            }
        }
    }
    public int maxUniqueSplit(String str) {
        s = str.toCharArray();
        maxi = Integer.MIN_VALUE;
        maxSplit(0, new HashSet<>());
        return maxi;
    }
}
