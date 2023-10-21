import java.util.*;
/*
 * IDEA : We use TreeSet to keep track of the active stacks. The reason we use TreeSet is because it
 *       maintains the order of the elements in the set. We use this property to get the index of the
 *       first (leftmost) active stack. We use a List of Stacks to store the actual stacks.
 * 
 */
class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> stacks; // List of Actual Stacks
    private TreeSet<Integer> activeStacks; // List of Stacks that are not full
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        
        this.activeStacks = new TreeSet<>();
    }
    
    public void push(int val) {
        // If no stacks are added OR the currently active stacks are all FULL at capacity, then do 2 things
        if(activeStacks.isEmpty()) {
            // Add a new stack
            stacks.add(new Stack<>());
            // Add the index of the new stack to the activeStacks TreeSet
            activeStacks.add(stacks.size() - 1);
        }
        // Get the index of the first (leftmost) active stack
        Integer firstActiveStackIndex = activeStacks.first();
        // Get the first (leftmost) active stack
        Stack<Integer> firstActiveStack = stacks.get(firstActiveStackIndex);
        // Push the value to the first (leftmost) active stack
        firstActiveStack.push(val);
        // If the first (leftmost) active stack is full, then remove it from the activeStacks TreeSet
        // to avoid considering it for future pushes
        if(firstActiveStack.size() == capacity)
            activeStacks.pollFirst();
    }
    // Pop the value from the rightmost stack
    public int pop() {
        return popHandler(stacks.size() - 1);
    }
    // Pop the value from the stack at the given index
    public int popAtStack(int index) {
        return popHandler(index);
    }
    // Handle Pop from the stack at the given index
    public int popHandler(int ind) {
        // If the index is invalid OR the stack at the given index is empty, then return -1
        // The last case can occur if we repeatedly pop from some stack in the middle
        if(ind < 0 || ind >= stacks.size() || stacks.get(ind).isEmpty())
            return -1;
        // Pop the value from the stack at the given index
        int val = stacks.get(ind).pop();
        // Since we popped a value from the stack, it definetly is no longer at capacity.
        // So, we add the index of the stack to the activeStacks
        activeStacks.add(ind);
        // We keep removing stacks from the right that are empty/fully popped.
        while(!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            // Casting is necessary becuase remove is a overloaded method
            // 1. remove(int index) : Removes the element at the specified position in this list (optional operation).
            // 2. remove(Object o) : Removes the first occurrence of the specified element from this list, if it is present (optional operation).
            stacks.remove((int) activeStacks.pollLast());
            
        }
        return val;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */