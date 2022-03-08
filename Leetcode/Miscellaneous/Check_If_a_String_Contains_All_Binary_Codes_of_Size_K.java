package Leetcode.Miscellaneous;

public class Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
    public boolean hasAllCodes(String s, int k) {
        int left = 0;
        Set<String> set = new HashSet<>();
        
        char str[] = s.toCharArray();
        if(str.length < k) return false;
        StringBuilder rollStr = new StringBuilder();
        
        for(int right = 0; right<k; right++)
            rollStr.append(str[right]);
        
        set.add(rollStr.toString());
        
        for(int right = k; right<str.length; right++)
        {
            rollStr.append(str[right]);
            rollStr.deleteCharAt(0);
            set.add(rollStr.toString());
        }
        return set.size()==(1<<k);
    }
}
