class Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++)
        {
            heap.add(stones[i]);
        }
        while(heap.size()>1)
        {
            int a = heap.poll();
            int b = heap.poll();
            if(a!=b)
                heap.add(a-b);
        }
        if(heap.size()==0)
            return 0;
        else
            return heap.poll();
        }
}