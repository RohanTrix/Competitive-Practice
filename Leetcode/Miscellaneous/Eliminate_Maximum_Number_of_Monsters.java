class Eliminate_Maximum_Number_of_Monsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double time[] = new double[dist.length];
        for( int i = 0; i<dist.length; i++)
        {
            time[i] =  dist[i]/( 1.0*speed[i] );
        }
        PriorityQueue<Double> pq = new PriorityQueue<Double>();
        for( int i = 0; i<time.length;i++)
        {
            pq.add(time[i]);
        }
        int passedMinute = 0;
        int counter = 0;
        while(!pq.isEmpty() && pq.peek()- passedMinute >0)
        {
            pq.poll();
            passedMinute++;
            
        }
        return passedMinute;
    }
}