package Leetcode.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restore_IP_Addresses {
    // Normal Recursion going from left to right and making sure each octet does not exceed 255
    class Solution {void debug(Object... o) { System.out.println(Arrays.deepToString(o));}
    List<String> res;
    char s[];
    public boolean isValid(String octet) {
        int n = octet.length();
        return (octet.equals("0") && n==1) || (octet.charAt(0)!='0' && Integer.valueOf(octet) <= 255);
            
    }
    public void dfs(int i, int cnt, String octet, String curr) {
        // debug(i, octet);
        if(cnt == 0)
        {
            if(i == s.length)
                res.add(curr.substring(0,curr.length()-1));
            return;
        }
        if(i == s.length)
            return;    
        octet+=s[i];
        if(isValid(octet))
        {
            // Taking current octet
            dfs(i+1, cnt-1, "", curr+octet+".");
            // Not taking current octet
            dfs(i+1, cnt, octet, curr);
        }
    }
        
    public List<String> restoreIpAddresses(String str) {
        s = str.toCharArray();
        res = new ArrayList<>();
        dfs(0, 4, "", "");
        return res;
    }
}
}
