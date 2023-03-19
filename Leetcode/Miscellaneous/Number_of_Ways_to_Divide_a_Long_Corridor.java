/**
 *      IDEA : This is a counting problem and most such problems are either solved by DP or Math. Here, constraints too high for DP
 * 
 *             Firstly, we know that there have to be even and non-zero no. of seats otherwise partition is not possible. Next, 
 *             think of this as a combination or counting problem. Between 2 pairs of seats, if we have x plants, then we have x+1
 *             ways of placing the partition between them. So if we consider all such consecutive seat pairs, we just have to multiply
 *             the no. of of ways between each pair for the final answer. 
 *              
 *             Quite simply, the no. of ways between the 2 pairs of seats is the 
 *              (index of the 1st seat of the 2nd pair) - (index of the 2nd seat of 1st pair) 
 * 
 *                      S p p p S x x x x x S p Spp
 *                      ---------           -----
 *                       1st pair          2nd pair         ---> 6 (5+1) partition positions in this example
 */ 


import java.util.ArrayList;
import java.util.List;

public class Number_of_Ways_to_Divide_a_Long_Corridor {
    public int numberOfWays(String corridor) {
        char cor[] = corridor.toCharArray();
        int seatCnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cor.length; i++)
            if (cor[i] == 'S') {
                seatCnt++;
                list.add(i);
            }
        if (seatCnt % 2 != 0 || seatCnt < 2)
            return 0;
        int mod = (int) 1e9 + 7;
        long res = 1L;
        for (int i = 2; i < list.size(); i += 2) {
            res *= 1L * (list.get(i) - list.get(i - 1));
            res %= mod;
        }
        return (int) res;

    }
}