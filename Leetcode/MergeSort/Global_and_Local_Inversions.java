
public class Global_and_Local_Inversions {
    static long merge(int arr[], int left, int mid, int right)
    {
        long num = 0;
        int len1 = mid - left + 1;
        int len2 = right-(mid+1) + 1;
        
        int leftArr[] = new int[len1];
        int rightArr[] = new int[len2];
        for(int i = left; i<=mid; i++)
            leftArr[i-left] = arr[i];
         for(int i = mid+1; i<=right; i++)
            rightArr[i-(mid+1)] = arr[i];
            
        //System.out.print(Arrays.toString(leftArr) + "\t"+ Arrays.toString(rightArr)+" ");
        int i =0, j = 0,k = left;
        ////////// INVERSION COUNTING ///////////////
        while(i<len1 && j<len2)
        {
            if(leftArr[i]>rightArr[j])
            {
                num+=(len1-i);
                arr[k++] = rightArr[j++];
            }
            else
            {
                arr[k++] = leftArr[i++];
            }
            
        }
        ///////// INVERASIOIN COUNT ENDS /////////////
        while(i<len1)
            arr[k++] = leftArr[i++];
        while(j<len2)
            arr[k++] = rightArr[j++];
        //System.out.println(num);
        return num;
    }
    static long mergeSort(int arr[], int left, int right)
    {
        if(left>=right)return 0;
        int mid = left + (right-left)/2;
        return mergeSort(arr,left,mid) + mergeSort(arr,mid+1,right) + merge(arr,left,mid,right);

    }
    public boolean isIdealPermutation(int[] nums) {
        int len = nums.length;
        int local = 0;
        for(int i = 0; i<len-1; i++)
        {
            local+=(nums[i]>nums[i+1])?1:0;
        }
        return mergeSort(nums,0, len-1)==local;
    }
}
