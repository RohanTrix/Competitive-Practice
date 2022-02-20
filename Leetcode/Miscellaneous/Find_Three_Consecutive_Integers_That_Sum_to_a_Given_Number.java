pulic class Find_Three_Consecutive_Integers_That_Sum_to_a_Given_Number
{
    // Consider 3 elements as mid-1, mid, mid+1
    // Sum of these is 3*mid
    public long[] sumOfThree(long num) {
        if(num%3==0)
        {
            num/=3;
            return new long[]{num-1, num, num+1};
        }
        return new long[]{};
    }
}