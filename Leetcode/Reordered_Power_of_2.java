package Leetcode;

public class Reordered_Power_of_2 {
    public boolean reorderedPowerOf2(int N) {
        int k = 1;
        int narr[] = count(N);
        while(k<=Math.pow(10,9))
        {
            if(Arrays.equals(narr, count(k)))
                return true;
            k<<=1;
        }
        return false;
    }
    public int[] count(int n)
    {
        int arr[] = new int[10];
        while(n>0)
        {
            arr[n%10]++;
            n/=10;
        }
        return arr;
    }
}
