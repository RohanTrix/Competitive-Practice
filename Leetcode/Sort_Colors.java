import java.util.*;
class Sort_Colors {
    public void sortColors(int[] nums) {
        
        int a=0, b=0,c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                a++;
            else if (nums[i]==1)
                b++;
            else
                c++;       
        }
        Arrays.fill(nums,0,a,0);
        Arrays.fill(nums,a,a+b,1);
        Arrays.fill(nums,a+b,a+b+c,2);
    }
}