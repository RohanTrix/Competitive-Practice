/**
 *   IDEA :
 *              `head` -> Points to the front of the circular deque
 *              `tail` -> Points to the index just after the last element in the deque
 *              `cnt` -> Stores the cnt of elements currently inserted in the Deque
 */

class MyCircularDeque {
    int[] q;
    int head, tail, cnt, cap;
    public MyCircularDeque(int k) {
        head = 0; tail = 0;
        cap = k;
        q = new int[cap];
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        head = (head - 1 + cap)%cap; // Handling negative mod;
        q[head] = value;
        cnt++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        q[tail] = value;
        tail++; tail%=cap;
        cnt++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        head++; head%=cap;
        cnt--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail = (tail - 1 + cap)%cap;
        cnt--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return q[head];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        int elementBeforeTail = (tail - 1 + cap)%cap;
        return q[elementBeforeTail];
    }
    
    public boolean isEmpty() {
        return cnt == 0;
    }
    
    public boolean isFull() {
        return cnt == cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */