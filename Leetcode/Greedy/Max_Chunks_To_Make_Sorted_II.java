/*
        IDEA : Clear Explanation in OneNote

        Short Idea: Maintain a leftMax and rightMin array. Basically, lets say we need to find a point to break it into 2 chunks called
                    first and second. Now to prove that these chunks should not be combined(to acheive max no. of chunks)
                    we should need to check whether the MAX element of first chunk is smaller or equal to MIN element of
                    the next chunk.

                    We iterate on each i from (0 to n-2)..and try to check the above condition to cut out the first
                    chunk from the second....when we do we increase our count. Initially, the count is one as
                    there is at least 1 chunk(full array). To check the condition efficiently, we can precalculate'
                    prefix MAX and suffix MIN.
*/
public class Max_Chunks_To_Make_Sorted_II
{
    public int maxChunksToSorted(int[] arr) {
        int sortedArr[] = arr.clone();
        int n = arr.length;
        int leftMax[] = new int[n];
        int rightMin[] = new int[n];
        leftMax[0] = arr[0]; rightMin[n-1] = arr[n-1];
        for(int i = 1; i<n; i++)
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        for(int i = n-2; i>=0; i--)
            rightMin[i] = Math.min(rightMin[i+1], arr[i]);
        
        int cnt = 1;
        for(int i = 0; i<n-1; i++)
        {
            if(leftMax[i]<=rightMin[i+1])
                cnt++;
        }
        return cnt;
    }
}