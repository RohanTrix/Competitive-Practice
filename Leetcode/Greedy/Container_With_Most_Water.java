/*
        IDEA: Finding most water is just finding the largest area. We can apply 2 
              pointer solution here. We start a pointer left and right from the ends
              of the height array. We always find the area formed the 2 pointers.
              Next we have a choice on which pointer to move. SINCE always on moving
              a pointer, the breadth has to decrease by one, we should move the smaller
              height building to reserve the larger for a better answer.
*/

public class Container_With_Most_Water
{
    public int maxArea(int[] height) {
        int n  = height.length;
        int left = 0, right = n-1;
        int maxi = 0;
        while(left<right)
        {
            maxi = Math.max(maxi, Math.min(height[left], height[right])*(right-left));
            if(height[left]<=height[right])
                left++;
            else
                right--;
        }
        return maxi;
    }
}