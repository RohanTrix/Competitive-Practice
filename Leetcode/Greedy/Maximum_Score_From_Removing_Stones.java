public class Maximum_Score_From_Removing_Stones {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);pq.add(b);pq.add(c);
        int score = 0;
        while(pq.size()>1)
        {
            a = pq.poll() - 1;
            b = pq.poll() - 1;
            if(a!=0) pq.add(a);
            if(b!=0) pq.add(b);
            score++;
        }
        return score;
    }
}
