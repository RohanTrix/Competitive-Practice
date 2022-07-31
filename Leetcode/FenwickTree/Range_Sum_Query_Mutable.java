package Leetcode.FenwickTree;
class NumArray { // Fenwick Tree
    private class Fenwick
     {
         int size;
         int bit[];
         public Fenwick(int n)
         {
             bit = new int[n+1];
             size = n;
         }
         public void update(int pos, int val)
         {
             while(pos<=size)
             {
                 bit[pos]+=val;
                 pos+=(pos&-pos);
             }
         }
         public int sum(int pos)
         {
             int res = 0;
             while(pos>0)
             {
                 res+=bit[pos];
                 pos-=(pos&-pos);
             }
             return res;
         }
     }
     Fenwick ft;
     int nums[];
     public NumArray(int[] nums) {
         int n = nums.length;
         this.nums = nums;
         ft = new Fenwick(n);
         for(int i = 0; i<n; i++)
             ft.update(i+1, nums[i]);
     }
     
     public void update(int index, int val) {
         
         int diff = val - nums[index];
         nums[index] = val;
         ft.update(index+1, diff);
     }
     
     public int sumRange(int left, int right) {
         return ft.sum(right+1) - ft.sum(left);
     }
 }
 
