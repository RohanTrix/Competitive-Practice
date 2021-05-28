class Jump_Game {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int i=n-2;
        int lastPosToReach = n-1;
        while(i>=0)
        {
            if( i + nums[i] >=lastPosToReach)
                lastPosToReach = i;
            i-=1;
        }
        return lastPosToReach==0;
    }
}