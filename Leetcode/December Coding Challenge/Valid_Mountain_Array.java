public class Valid_Mountain_Array {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3) return false;
        int ind = n-2;
        for(int i = 1; i<n-1;i++)
        {
            if(arr[i]>arr[i-1] )
            {
                if(arr[i]>arr[i+1]){
                    ind = i;
                    break;
                }
            }
            else
            {
                return false;
            }
        }
               
        
        while(ind < n-1)
        {
            if(arr[ind] <= arr[ind+1])
                return false;
            ind++;
        }
        return true;
    }
}