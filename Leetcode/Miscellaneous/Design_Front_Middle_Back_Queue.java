/**
 *      IDEA : Maintain 2 Deques
 */

class FrontMiddleBackQueue {
    Deque<Integer> left, right;
    int cnt;
    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        cnt = 0;
    }
    
    public void pushFront(int val) {
        left.offerFirst(val);
        cnt++;
        if(cnt%2!=0)
            right.offerFirst(left.pollLast());
    }
    
    public void pushMiddle(int val) {
        if(cnt%2==0)
            right.offerFirst(val);
        else
            left.offerLast(val);
        cnt++;
    }
    
    public void pushBack(int val) {
        if(cnt%2!=0)
            left.offerLast(right.pollFirst());
        cnt++;
        right.offerLast(val);
    }
    
    public int popFront() {
        if(cnt == 0) return -1;
        if(cnt%2 != 0)
        {
            left.offerLast(right.pollFirst());
        }
        cnt--;
        return left.pollFirst();
    }
    
    public int popMiddle() {
        if(cnt == 0) return -1;
        int val;
        if(cnt%2==0)
            val = left.pollLast();
        else
            val = right.pollFirst();
        cnt--;
        return val;
    }
    
    public int popBack() {
        if(cnt == 0) return -1;
        if(cnt%2 == 0)
            right.offerFirst(left.pollLast());
        cnt--;
        return right.pollLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
