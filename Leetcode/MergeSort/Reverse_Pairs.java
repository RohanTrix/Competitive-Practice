/*
        PRE-REQ -> Count Inversions using merge sort
 *      IDEA : The idea is very similar to Inversion Count. Here..however, we have a condition nums[i] > 2*nums[j]*2.
 *             So in one pass we count such pairs..and then we merge the arrays.
 * 
 */
public class Reverse_Pairs {
    // Merge sort solution
    int nums[];
    public int merge(int left, int mid, int right)
    {
        int len1 = mid-left+1, len2 = right-mid;
        long leftArr[] = new long[len1];
        long rightArr[] = new long[len2];
        for(int i = left; i<=mid; i++)
            leftArr[i-left] = nums[i];
        for(int i = mid+1; i<=right; i++)
            rightArr[i-(mid+1)] = nums[i];
        
        int i = 0, j = 0, k = left;
        int cnt = 0;
        // Counting Reverse Pairs
        while(i<len1 && j<len2)
        {
            if(leftArr[i] <= 2*rightArr[j])
                i++;
            else // All elements from i and after in the first array will be bigger than 2*rightArr[j] for current j.
            {
                cnt+=len1-i;
                j++;
            }
        }
        
        // Merging 2 sorted arrays
        i = 0; j = 0;
        while(i<len1 && j<len2)
        {
            if(leftArr[i]<rightArr[j])
                nums[k++] = (int)leftArr[i++];
            else
                nums[k++] = (int)rightArr[j++];
        }
        while(i<len1)
            nums[k++] = (int)leftArr[i++];
        while(j<len2)
            nums[k++] = (int)rightArr[j++];
        return cnt;
    }
    int mergeSort(int left, int right)
    {
        if(left>=right) return 0;
        int mid = (left+right)/2;
        return mergeSort(left, mid) + mergeSort(mid+1, right) + merge(left, mid, right);
        
    }
    public int reversePairs(int[] nums) {
        this.nums = nums;
        return mergeSort(0, nums.length-1);
    }
}
