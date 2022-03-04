/*
    IDEA : We keep two ArraysLists, one to maintain the current level and another which would become the
           next current list. Its a simulation problem.

           Follow the code for better understanding, hard to explain. Bascially a lever order type approach
*/
public class Champagne_Tower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        ArrayList<Double> currBuckets = new ArrayList<>();
        currBuckets.add(1.0*poured);
        for(int row = 1; row<=query_row; ++row)
        {
            ArrayList<Double> nextBuckets = new ArrayList<>();
            for(double num : currBuckets)
            {
                num = Math.max(0, num-1);
                if(nextBuckets.size()==0)
                {
                    nextBuckets.add(num/2.0);
                    nextBuckets.add(num/2.0);
                }
                else
                {
                    double extra = nextBuckets.get(nextBuckets.size()-1);
                    nextBuckets.remove(nextBuckets.size()-1);
                    nextBuckets.add( extra+ (num/2.0));
                    nextBuckets.add(num/2.0);
                }
            }
            currBuckets = new ArrayList<>(nextBuckets);
        }
        return Math.min(currBucket.get(query_glass),1.0);
    }
}
