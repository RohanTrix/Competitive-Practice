/*
    IDEA: At first, the problem feels DP-like, but on thinking about it,
          it is very tough to form a DP state/transition for this

          Hence we go for a Greedy apprach. There are 2 things we want,
            1) On player p's turn, they want to choose the max stone first 
               before the other player takes it
            2) At the same time, they do not want the other player to win as they play optimally
               So they wanna take that coin that is a very high scoring point for their opponent

            So since we want both these characteristics, we take the largest with alice[i]+bob[i],
            at each player's turn
*/
public class Stone_Game_VI {
    public int stoneGameVI(int[] alice, int[] bob) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a,b) -> Integer.compare(alice[b]+bob[b], alice[a]+bob[a]));
        for(int i =0;i<alice.length; i++) pq.add(i);
        int p = 0;
        int finalScore =0;
        while(!pq.isEmpty())
        {
            if(p==0)
                finalScore+=alice[pq.poll()];
            else
                finalScore-=bob[pq.poll()];
            p^=1;
        }
        if(finalScore==0) return 0;
        return finalScore>0?1:-1;
    }
}
