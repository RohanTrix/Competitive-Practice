```java


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    static long merge(long arr[], int left, int mid, int right)
    {
        long num = 0;
        int len1 = mid - left + 1;
        int len2 = right-(mid+1) + 1;
        
        long leftArr[] = new long[len1];
        long rightArr[] = new long[len2];
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
        while(i<len1)
            arr[k++] = leftArr[i++];
        while(j<len2)
            arr[k++] = rightArr[j++];
        //System.out.println(num);
        return num;
    }
    static long mergeSort(long arr[], int left, int right)
    {
        if(left>=right)return 0;
        int mid = left + (right-left)/2;
        return mergeSort(arr,left,mid) + mergeSort(arr,mid+1,right) + merge(arr,left,mid,right);

    }
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr,0,(int)N-1);
        
        
    }
}
```