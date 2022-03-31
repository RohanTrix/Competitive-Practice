public class Design_a_Stack_With_Increment_Operation
{
    class CustomStack {
        int arr[];
        int top = -1;
        public CustomStack(int maxSize) {
            arr = new int[maxSize];
            
        }
        
        public void push(int x) {
            if(top == arr.length-1) return;
            arr[++top] = x;
        }
        
        public int pop() {
            if(top == -1) return -1;
            return arr[top--];
        }
        
        public void increment(int k, int val) {
            for(int i = 0; i<=Math.min(top, k-1); i++)
                arr[i]+=val;
            
        }
    }
    
    /**
     * Your CustomStack object will be instantiated and called as such:
     * CustomStack obj = new CustomStack(maxSize);
     * obj.push(x);
     * int param_2 = obj.pop();
     * obj.increment(k,val);
     */
}