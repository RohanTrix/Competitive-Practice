class StockSpanner {
    // LOGIC : https://leetcode.com/problems/online-stock-span/discuss/640358/JAVA-Solution-With-visualization-and-easy-explained!
    Deque<int[]> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int p[] = {price, 1};
        while(!stack.isEmpty() && stack.peek()[0] <= price)
            p[1]+=stack.poll()[1];
        stack.push(p);
        return p[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */