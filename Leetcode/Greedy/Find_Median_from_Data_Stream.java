class MedianFinder {
    // REFER : Tech Dose Or Keerti Puswani
    // Idea is that median divides the array into 2 halfs. So we try to maintain this demarkation
    // by using maxPQ for left half and minPQ for right half
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;
    int cnt;
    public MedianFinder() {
        maxpq = new PriorityQueue<>(Collections.reverseOrder());
        minpq = new PriorityQueue<>();
        cnt = 0;
    }
    
    public void addNum(int num) {
        cnt++;  
        if(maxpq.isEmpty() || maxpq.peek()>num)
            maxpq.add(num);
        else
            minpq.add(num);
        
        if(cnt%2 == 0)
        {
            if(maxpq.size()>minpq.size())
                minpq.add(maxpq.poll());
            if(maxpq.size()<minpq.size())
                maxpq.add(minpq.poll());
        }
        else
        {
            if(maxpq.size()<minpq.size())
                maxpq.add(minpq.poll());
        }
    }
    
    public double findMedian() {

        if(cnt%2==0)
            return 1.0*(minpq.peek()+maxpq.peek())/2;
        else
            return maxpq.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */