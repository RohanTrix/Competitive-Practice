/**
 * IDEA : First we build a list of Fibonacci numbers upto k. This takes kind of linear time.
 *        Now, we start to subtract the highest fibo from k as many times as possible. After that,
 *        we try to remove the next largest fibo no. and so on.
 */


public class Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(1);
        while(list.get(list.size()-1)+list.get(list.size()-2)<=k)
            list.add(list.get(list.size()-1)+list.get(list.size()-2));
        int moves = 0;
        for(int i = list.size()-1; i>=0; i--)
        {
            int cnt = k/list.get(i); // max times curr fibo no. can be subtracted from k
            k-=list.get(i)*cnt;
            moves+=cnt;
        }
        return moves;
    }
}
