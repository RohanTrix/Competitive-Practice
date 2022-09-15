/**
 *      IDEA : Sorting gives us an ordering so we should sort the array first. The next point to observe is that
 *             that the last element will now be the largest element. So this element should have the been the twice of
 *             some smaller element. SO using one pointer, we go backwards in until we find a element whose twice should be equal to
 *             current element. Now, save this in answer array. And also set the value at that pointer to -1 to indicate
 *             that this element has already been taken.....
 * 
 *             The greedy idea here is that for the largest element, we try to find a candidate....if found, we store it and mark
 *             this element as -1 as to not consider it again....next we do the same for next largest element...which will have its
 *             half smaller or equal to half of the largest.
 * 
 *             If at any point, we see we run out of elements that we can assign, we return empty array.
 *             Otherwise return answer.
 * 
 */

public class Find_Original_Array_From_Doubled_Array
{
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0) return new int[]{};
        int n = changed.length/2;
        int ans[] = new int[n];
        Arrays.sort(changed);
        
        int i = 2*n-1, j = 2*n-2;
        int k = 0;
        while(k<n)
        {
            int twice = changed[i];
            while(j>=0 && 2*changed[j]!=twice)
                j--;
            if(j == -1) return new int[]{};
            ans[k++] = changed[j];
            changed[j] = -1;
            i--;
            while(i>=0 && changed[i]==-1)
                i--;
        }
        return ans;
        
    }
}