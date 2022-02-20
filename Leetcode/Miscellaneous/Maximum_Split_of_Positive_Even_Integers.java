/*
        IDEA : We try to remove the even positive number 2, then 4, then 6..until we cannot.
               Moreover, it might happen that during recursion, if sum=16
               and the next smallest no. to be remove is 8, then that leaves us with sum=8 
               and next smallest even no. as 10...but 10>8 and hence we cannot break 16 and have to
               add it as it is.
*/
public class Maximum_Split_of_Positive_Even_Integers {
    List<Long> res = new ArrayList<>();
    public boolean recur(long sum, long num)
    {
        if(num>sum)
            return false;
        if(sum == 0)
            return true;
        
        boolean b = recur(sum-num, num+2);
        if(b) res.add(num);
        else res.add(sum);
        return true;
    }
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum%2!=0) return res;
        recur(finalSum, 2);
        return res;
        
    }
}
