/*
        IDEA : Explained in OneNote
*/
public class Max_Chunks_To_Make_Sorted
{
    public int maxChunksToSorted(int[] arr) {
        
        int right = 0, cnt = 0;
        int maxPos = 0;
        for(right = 0; right<arr.length; right++)
        {
            maxPos = Math.max(maxPos,arr[right]);
            if(maxPos == right)
                cnt++;
            
        }
        return cnt;
    }
}