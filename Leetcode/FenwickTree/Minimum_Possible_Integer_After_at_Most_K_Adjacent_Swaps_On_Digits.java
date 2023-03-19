import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;

public class Minimum_Possible_Integer_After_at_Most_K_Adjacent_Swaps_On_Digits
{
    // REFER for explanation : https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/discuss/720548/O(n-logn)-or-Detailed-Explanation
    // Instead of Segment Tree, Fenwick Tree is used
    /*
     *      USAGE OF Fenwick Tree : To count the no. of elements before a element. Everytime, we want to place a letter, we need to check
     *                              how many swaps it will take to place it at current pos. The no. of swaps is equal to the no. of
     *                              elements in front of it. Using a fenwick tree, we can mark and unmark the presence of a value
     *                              at a particular index.
     *                              Initally, all positions from 1 to n and marked. Now..based on the greedy logic in the link above,
     *                              we first calculate the no. of swaps need by summing up the count of marked cells before our index.
     *                              after placing the digit in our answer, we need to unmark from current cell. So we do a fenwick tree update of -1.
     * 
     */


    public String minInteger(String s, int k) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        char num[] = s.toCharArray();
        int n = num.length;
        for(int i = 0; i<10; i++)
            map.put(i, new LinkedList<>());
        for(int i = 0; i<n; i++)
            map.get(num[i]-'0').add(i+1);
        
        Fenwick ft = new Fenwick(n);
        for(int i = 1; i<=n; i++)
            ft.update(i,1);
        
        char ans[] = new char[n];
        for(int i = 1; i<=n; i++)
        {
            for(int dig = 0; dig<10; dig++)
            {
                Queue<Integer> q= map.get(dig);
                if(q.isEmpty()) continue;
                int swapsNeeded = ft.sum(q.peek()-1);
                if(swapsNeeded>k) continue;
                k-=swapsNeeded;
                ans[i-1] = (char)(dig+'0');
                ft.update(q.poll(),-1);
                break;
            }
        }
        return new String(ans); 
    }
    class Fenwick
    {
        int bit[];
        int size;
        public Fenwick(int n)
        {
            size = n;
            bit = new int[n+1];
        }
        public void update(int pos, int val)
        {
            while(pos<=size)
            {
                bit[pos]+=val;
                pos+=Integer.lowestOneBit(pos);
            }
        }
        public int sum(int pos)
        {
            int res = 0;
            while(pos>0)
            {
                res+=bit[pos];
                pos-=Integer.lowestOneBit(pos);
            }
            return res;
        }
    }
}