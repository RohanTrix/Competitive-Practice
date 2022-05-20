package Leetcode.Greedy;

//  REFER : https://leetcode.com/problems/delete-columns-to-make-sorted-ii/discuss/203171/C%2B%2B-12-ms-brute-force
public class Delete_Columns_to_Make_Sorted_II {
    public int minDeletionSize(String[] strs) {
        int cnt = 0;
        int n = strs[0].length();
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i<strs.length; i++)
        {
            for(int p = 0; p<n; p++)
            {
                if(set.contains(p)) continue;
                if(strs[i].charAt(p) ==  strs[i-1].charAt(p)) continue;
                char ch1 = strs[i-1].charAt(p);
                char ch2 = strs[i].charAt(p);
                if(ch2<ch1) 
                {
                    cnt++;
                    set.add(p);
                    i = 0;
                }
                break;
            }
        }
        return cnt;
    }
}
