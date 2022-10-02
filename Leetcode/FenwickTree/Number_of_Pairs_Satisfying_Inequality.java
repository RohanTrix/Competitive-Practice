/**
 *          IDEA : First rearrange this equation to simplify:
 *                  -> nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
 *                  -> nums1[i] - nums2[i] <= nums1[j] - nums2[j] + diff;
 *                  ->       nums3[i]      <=         nums3[j]    + diff
 * 
 *                 Problem is reduced to finding for every jth element in nums3, find the number of
 *                 elements which are <= nums3[j] + diff.......to solve this counting problem,
 *                 we will use a Fenwick Tree over a count array.
 *                 *NOTE* -> TO HANDLE NEGATIVE CASES, WE SHIFT ALL INTEGERS BY A POSITIVE CONSTRANT
 *                 NOW,
 *                 Everytime we come at jth element in nums3, we query in Fenwick Tree, the sum count of elements
 *                 <= nums3[j] + diff
 *                 After updating answer, we increment the frequency of nums3[j] in Fenwick Tree by 1.
 * 
 */

public class Number_of_Pairs_Satisfying_Inequality {
    
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        for(int i = 0; i<n; i++)
            nums1[i] -= nums2[i]; // Creating nums3 in num1 itself
        for(int i = 0; i<n; i++)
            nums1[i]+=(int)1e5;
        long cnt = 0;
        Fenwick ft = new Fenwick((int)5e5);
        for(int i = 0; i<n; i++)
        {
            int val = nums1[i] + diff;
            cnt+=ft.sum(val);
            ft.update(nums1[i], 1);
        }
        return cnt;
    }

    private class Fenwick
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
