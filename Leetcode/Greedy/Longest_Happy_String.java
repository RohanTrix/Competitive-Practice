public class Longest_Happy_String
{
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(a>0) pq.offer(new Pair('a', a));
        if(b>0) pq.offer(new Pair('b', b));
        if(c>0) pq.offer(new Pair('c', c));
        
        StringBuilder s = new StringBuilder();
        s.append("X"); // Extra char added at beginning to handle corner case
        while(pq.size()>1)
        {
            Pair top = pq.poll();
            if(top.cnt >=2)
            {
                top.cnt-=2;
                s.append(""+top.ch+top.ch);
            }
            else
            {
                top.cnt--;
                s.append(""+top.ch);
            }
            Pair top2 = pq.poll();
            if(top2.cnt>=2 && top.cnt<top2.cnt)
            {
                s.append(""+top2.ch+top2.ch);
                top2.cnt-=2;
            }
            else
            {
                s.append(""+top2.ch);
                top2.cnt--;
            }
            if (top.cnt > 0)
				pq.add(top);
			if (top2.cnt > 0)
				pq.add(top2);
        }
        
        if(!pq.isEmpty() && pq.peek().ch != s.charAt(s.length()-1))
        {
            if(pq.peek().cnt>=2) s.append(""+pq.peek().ch+pq.peek().ch);
            else s.append(""+pq.peek().ch);
        }
        return s.toString().substring(1);
    }
    class Pair implements Comparable<Pair>
    {
        char ch;
        int cnt;
        public Pair(char ch , int cnt)
        {
            this.ch = ch;
            this.cnt = cnt;
        }
        public int compareTo(Pair p)
        {
            return cnt - p.cnt;
        }
    }
}