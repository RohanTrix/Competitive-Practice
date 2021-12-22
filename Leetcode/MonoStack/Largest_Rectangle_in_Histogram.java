

public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        MonotonicStack st = new MonotonicStack(heights);
        int n = heights.length;
        int maxi = 0;
        for (int i = 0; i < n; i++) {

            int left = st.firstSmallerToLeft[i];
            left = left == -1 ? 0 : left + 1;

            int right = st.firstSmallerToRight[i];
            right = right == -1 ? n - 1 : right - 1;

            maxi = Math.max(maxi, (right - left + 1) * heights[i]);
        }
        return maxi;
    }

    static class MonotonicStack {
        int[] nums, firstSmallerToLeft, firstSmallerToRight;

        public MonotonicStack(int[] nums) {
            this.nums = nums;
            this.firstSmallerToLeft = new int[nums.length];
            this.firstSmallerToRight = new int[nums.length];

            Arrays.fill(firstSmallerToLeft, -1);
            Arrays.fill(firstSmallerToRight, -1);

            buildIncreasingStack();
        }

        void buildIncreasingStack() {
            int n = nums.length;
            Deque<Integer> stack = new ArrayDeque<>(n);
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && (nums[stack.peek()] >= nums[i])) {
                    firstSmallerToRight[stack.poll()] = i;
                }
                if (!stack.isEmpty()) {
                    firstSmallerToLeft[i] = stack.peek();
                }
                stack.push(i);
            }
        }

        public int[] getFirstSmallerToLeft() {
            return this.firstSmallerToLeft;
        }

        public int[] getFirstSmallerToRight() {
            return this.firstSmallerToRight;
        }
    }
}
