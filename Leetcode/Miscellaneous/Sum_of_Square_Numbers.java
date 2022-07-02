public class Sum_of_Square_Numbers {
    // Math.sqrt takes O(log n) time....so total time complexity is (n log n);
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a*a<=c; a++)
        {
            double sqrt = Math.sqrt(c - (a*a));
            if(sqrt == (int)sqrt)
                return true;
        }
        return false;
    }
}
