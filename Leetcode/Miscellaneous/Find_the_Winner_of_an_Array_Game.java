public class Find_the_Winner_of_an_Array_Game {
    // IDEA : Simulate the process
    public int getWinner(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int num : arr) dq.offerLast(num);
        int winner = -1, wincnt = 0;
        for(int i = 0; i<arr.length; i++)
        {
            int a = dq.pollFirst(), b = dq.pollFirst();
            if(a>b)
            {
                wincnt++;
                winner = a;
                
            }
            else
            {
                wincnt = 1;
                winner = b;
            }
            if(wincnt == k) return winner;
            dq.offerFirst(winner);
            dq.offerLast((winner == a)?b:a);
        }
        return dq.peekFirst();
    }
}
