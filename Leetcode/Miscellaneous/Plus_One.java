public class Plus_One {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        
        for(int i =digits.length -1; i>=0 ; i--)
        {
            digits[i]+=carry;
            if(digits[i]==10) digits[i] = 0;
            else carry = 0;
        }
        if(carry==0) return digits;
        int arr[] = new int[digits.length+1];
        System.arraycopy(digits, 0, arr, 1, digits.length);
        arr[0] = 1;
        return arr;
    }
}
