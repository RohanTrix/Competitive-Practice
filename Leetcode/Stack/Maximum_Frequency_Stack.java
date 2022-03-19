// REFER : 

public class Maximum_Frequency_Stack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }
    // Increase the frequency in freqMap
    // Update maxFreq.
    // Create new Stack if maxFreq changed
    public void push(int val) {
        int newFreq = freqMap.getOrDefault(val, 0)+1;
        freqMap.put(val, newFreq);
        if(newFreq > maxFreq)
            maxFreq = newFreq;
        freqStack.computeIfAbsent(newFreq, f -> new Stack<>()).push(val);
        
    }
    // Return and remove the top of maxFreq
    // Update maxFreq (Decrementing, if applicable)
    // Update the freqMap
    public int pop() {
        Stack<Integer> st = freqStack.get(maxFreq);
        int topval = st.pop();
        if(st.isEmpty()) maxFreq--;
        freqMap.put(topval, freqMap.get(topval)-1);
        return topval;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
