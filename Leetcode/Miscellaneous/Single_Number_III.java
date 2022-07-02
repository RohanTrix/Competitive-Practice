public class Single_Number_III {
    // REFER : https://youtu.be/pnx5JA9LNM4
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums)
            xor^=num;
        int lsb = Integer.lowestOneBit(xor);
        int xor0 = 0;
        int xor1 = 0;
        for(int num : nums)
        {
            if((num&lsb)==0)
                xor0^=num;
            else
                xor1^=num;
        }
        return new int[]{xor0,xor1};
    }
}
