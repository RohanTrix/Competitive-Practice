/*
    IDEA : The wrong though process wud be to go at every middle i (i haveing both neighbour) and then assigning it
            the 
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