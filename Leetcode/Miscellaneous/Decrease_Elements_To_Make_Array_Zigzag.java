public class Decrease_Elements_To_Make_Array_Zigzag {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        if(n==2)return nums[0]==nums[1]?1:0;
        int steps1 = 0, steps2 = 0;
        for(int i = 1; i<n; i+=2)
        {
            int a = 0, b = 0;
            if(i-1>=0 && nums[i]>=nums[i-1])a = nums[i]-nums[i-1] +1;
            if(i+1<=n-1 && nums[i]>=nums[i+1])b = nums[i]-nums[i+1] +1;
            steps1+=Math.max(a,b);
        }
        for(int i = 0; i<n; i+=2)
        {
            int a = 0, b = 0;
            if(i-1>=0 && nums[i]>=nums[i-1])a = nums[i]-nums[i-1] +1;
            if(i+1<=n-1 && nums[i]>=nums[i+1])b = nums[i]-nums[i+1] +1;
            steps2+=Math.max(a,b);
        }
        return Math.min(steps1, steps2);
    }
}
