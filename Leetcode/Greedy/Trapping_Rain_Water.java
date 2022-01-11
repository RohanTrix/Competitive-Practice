/*
    IDEA: We need to keep track of the maximum heights to both left and right of every index
    (if it is larger than ith element) as the minimum of them will be the level at which 
    water will be filled. If we find that level, we only have to subtract the 
    height of the building from there. 
*/
// Also REFER :https://youtu.be/C8UjlJZsHBw
class Trapping_Rain_Water {
    public int trap(int[] height) {

        int n = height.length;
        // Stores largest height to the left greater than ith element
        int maxLeft[] = new int[n]; maxLeft[0] = -1;
        // Stores largest height to the right greater than ith element
        int maxRight[] = new int[n]; maxRight[n-1] = -1;
        // We find if there is max height to the left larger than ith element, if not then set to -1
        for(int i = 1; i<n; i++)
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1])>height[i]?Math.max(maxLeft[i-1],height[i-1]):-1;
        // Similar logic for right
        for(int i = n-2; i>=0; i--)
            maxRight[i] = Math.max(maxRight[i+1],height[i+1])>height[i]?Math.max(maxRight[i+1],height[i+1]):-1;
        
        int water = 0;
        for(int i=1;i<n-1; i++)
        {
            // Since only elements having larger than current element on BOTH sides will hold water
            if(maxLeft[i]==-1 || maxRight[i]==-1) continue;

            // Minimum of leftmax and right max gives the height and amount is given after subtracting height
            // of building
            water+= Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return water;
    }
}