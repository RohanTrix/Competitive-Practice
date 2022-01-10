public class Sliding_Window_Maximum {
    // Explanation of Deque in OneNote
    // Code explanation below

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>(); // Decreasing queue
        int arr[] = new int[n-k+1]; // Size of the answer array
        // We firstly setup our monoqueue for first k size window
        for(int i =0; i<k; i++)
        {
            // Keep removing elements that can never be a part of deque from the back
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i])
                q.pollLast();
            q.offerLast(i); // Finally when we find ith element's sorted position,
                            // push it at the back
        }
        arr[0] = nums[q.peekFirst()]; // Save the first answer
        for(int i = 1;i<n-k+1;i++)
        {
            // If the max element was the leftmost element in the current window,
            // we have to remove it as it will not be a part of next window.
            if(q.peekFirst()==(i-1)) q.pollFirst();

            // Similar logic as previous loop
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i+k-1])
                q.pollLast();
            q.offerLast(i+k-1); // Push the new rightmost element in the new window
            arr[i] = nums[q.peekFirst()]; // Save the answer from front of queue
        }
        return arr;
    }
}
