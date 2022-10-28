public class Find_XOR_Sum_of_All_Pairs_Bitwise_AND
{
    // REFER : https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/discuss/1163992/JavaC++Python-Easy-and-Concise-O(1)-Space/910278
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0, xor2 = 0;
        for(int num : arr1)
            xor1^=num;
        for(int num : arr2)
            xor2^=num;
        return xor1 & xor2;
        
    }
}