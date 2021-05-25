class MonoStack
{
    int[] nums, firstLargerToRight;
    public MonoStack(int nums[])
    {
        this.nums = nums;
        this.firstLargerToRight = new int[nums.length];
        Arrays.fill(firstLargerToRight, -1);
        buildDecreasingStack();
    }
    private void buildDecreasingStack()
    {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && (nums[stack.peek()] < nums[i])) {
                firstLargerToRight[stack.poll()] = i;
            }
            stack.push(i);
        }
    }
}
public class Daily_Temperatures {
    public int[] dailyTemperatures(int[] temp) {
        MonoStack ms = new MonoStack(temp);
        for(int i =0 ;i<ms.firstLargerToRight.length;i++)
        {
            ms.firstLargerToRight[i] = Math.max(0,ms.firstLargerToRight[i] - i);
        }
        return ms.firstLargerToRight;
    }
}
