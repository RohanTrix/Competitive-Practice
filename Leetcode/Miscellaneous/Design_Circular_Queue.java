class MyCircularQueue {
    int queue[];
    int front, rear, len, cap;
    public MyCircularQueue(int k) {
        queue = new int[k];
        this.cap = k;
        this.len = 0;
        this.front = 0;
        this.rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        len++;
        queue[rear] = value;
        rear++; rear%=cap;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front++;front%=cap;
        len--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        int actualInd = (rear - 1 + cap)%cap;
        return queue[actualInd];
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */