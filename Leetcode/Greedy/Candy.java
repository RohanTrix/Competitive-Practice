/*
    IDEA : The wrong though process wud be to go at every middle ith element (i having both neighbour) and 
            then trying to assign coins to it....Whenever we are concerned with checking both neighbours
            and assigning a value to current, we should think of doing a left pass and a right pass.

            Here we do a left pass...and for every i that has higher rating than its neighbour i-1,
            we will set ratings[i] = 1 + ratings[i-1]. 
            This will ensure that if we have a larger ratings[i] than ratings[i-1], we have assigned i a
            no. of coins just more than its prev neighbour.

            Now we do a right to left pass, checking if i's rating is more than i+1...but here,
            we need to remember that we have already assigned mini no. of coins based on one neighbour side.
            So if the right neighbour has smaller rating, but has a smaller no. of coins than the left neighbour,
            then we need to to keep left neighbours value only to satisfy both neighbours. This means taking
            max of coins we would have to place for the 2 neighbours.

            Finally, we just sum up the total number of coins used.
*/
import java.util.stream.*;
public class Candy
{
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies,1);
        int n = ratings.length;
        for(int i = 1; i<n; i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                candies[i] = candies[i-1]+1;
            }
        }
        for(int i = n-2; i>=0; i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
        }
        return IntStream.of(candies).sum();
    }
}