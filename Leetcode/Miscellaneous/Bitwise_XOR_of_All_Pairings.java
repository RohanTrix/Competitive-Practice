public class Bitwise_XOR_of_All_Pairings {
    /*
     *  IDEA : One element of nums1 will be used len2 times....if len2 is EVEN, xors cancel out..else that element will remain
     *         This will be true for each element in num1...so either we will have 0 or one occurence of each num in nums1.
     *         Apply similar logic for nums2.....Thus, if needed, find xor for each array...and xor them together.
     * 
     */
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;
        for(int num : nums1)
                xor1^=num;
        for(int num : nums2)
                xor2^=num;
        
        int n1 = nums1.length, n2 = nums2.length;
        if(n2%2 == 0)
            xor1 = 0;
        if(n1%2 == 0)
            xor2 = 0;
        return xor1^xor2;
    }
}
