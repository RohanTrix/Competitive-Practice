package Leetcode.Miscellaneous;

// Take/Not take type of backtracking. Only take if we can by checking running mask


// Nice trick which could be used : 	If two binary representations do not contain any common bit then their XOR should be equal to their OR

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    public int maxLen(int ind, int mask, List<String> arr)
    {
        if(ind == -1)
        {
            int cnt = 0;
            while(mask!=0)
            {
                mask = mask & (mask -1);
                cnt++;
            }
            return cnt;
        }
        int len = maxLen(ind-1, mask, arr);
        // Check if str can be added to subseq
        boolean canAdd = true;
        for(char ch : arr.get(ind).toCharArray())
        {
            if((mask&(1<<(ch-'a')))!=0) canAdd = false;
            mask = mask|(1<<(ch-'a'));
        }
        if(canAdd)
            len = Math.max(len,maxLen(ind-1, mask, arr));
        return len;
        
    }
    public int maxLength(List<String> arr) {

        return maxLen(arr.size()-1, 0, arr);
    }
}
