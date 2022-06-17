public class Restore_IP_Addresses {
    // Normal Recursion going from left to right and making sure each octet does not exceed 255
    List<String> ans = new ArrayList<>();
    public void dfs(int i, int octetNum, char s[], List<String> curr)
    {
        if(octetNum == 5 && i == s.length)
        {
            String tmp = curr.get(0)+'.'+curr.get(1)+'.'+curr.get(2)+'.'+curr.get(3);
            ans.add(tmp);
            return;
        }
        if(octetNum>5 || i == s.length) return;
        if(s[i] == '0')
        {
            curr.add("0");
            dfs(i+1, octetNum+1, s, curr);
            curr.remove(curr.size()-1);
        }
        else
        {
            String tmp = "";
            for(int p = i; p<Math.min(s.length,i+3); p++)
            {
                tmp+=s[p];
                if(Integer.valueOf(tmp)<256)
                {
                    curr.add(tmp);
                    dfs(p+1, octetNum+1, s, curr);
                    curr.remove(curr.size()-1);
                }
                else break;
            }
        }
    }
    public List<String> restoreIpAddresses(String ip) {
        dfs(0, 1, ip.toCharArray(), new ArrayList<>());
        return ans;
    }
}
