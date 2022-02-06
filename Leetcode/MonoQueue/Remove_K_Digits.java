/*
    IDEA : Making the smallest num is kinda making the lexicographically smallest string. Basically, we want to make the string into 
           an increasing sequence. So the idea is to use a Increasing Monotonic Queue with a lil condition.

           We traverse over the string. If we have moves available, we want to replace the numbers before the current no. which
           are bigger than the current number. This is basically making the increasing queue. After removing and decrementing 
           the amount of elements replaces as the no. of moves made, we append curr num to the end.

           After this process of making an increasing queue has ended. We might or might not be left with any moves.
           Firstly, since this a number, we want to get rid of leading zeros in the front of the queue.
           
           Next, if we have any moves left, then that means we have increasing queue to operate on. In this case, we simply want
           to remove the largest elements in the queue, which will be basically present towards the end of the queue.
*/
public class Remove_K_Digits {
    public String removeKdigits(String number, int k) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        
        char num[] = number.toCharArray();
        // Building an increasing queue till moves are left. If moves over, we just insert into the queue.
        for(int i = 0; i<num.length; i++)
        {
            while(k>0 && !q.isEmpty() && num[i]<q.peekLast())
            {
                q.pollLast();
                k--;
            }
            q.offerLast(num[i]);
        }
        while(!q.isEmpty() && q.peekFirst()=='0') 
            q.pollFirst();
        while(k>0)
        {
            q.pollLast(); k--;
        }
        StringBuilder s = new StringBuilder();
        while(!q.isEmpty())
            s.append(q.pollFirst());

        if(s.length()==0) return "0";
        return s.toString();
    }
}
