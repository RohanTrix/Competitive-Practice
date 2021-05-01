package Leetcode;
class SeatManager {
    int arr[];
    int len;
    public SeatManager(int n) {
        arr = new int[n];
        Arrays.fill(arr, 0);
        len = n;
    }
    
    public int reserve() {
        for(int i = 0;i<len;i++){
            if (arr[i]==0)
            {
                arr[i] = 1;
                return i+1;
            }
        }
        return len;
            
    }
    public void unreserve(int seat) {
        arr[seat-1] = 0;
    }
}
