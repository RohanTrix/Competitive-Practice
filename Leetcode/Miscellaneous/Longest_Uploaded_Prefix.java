public class Longest_Uploaded_Prefix {
    int endPoint,n;
    boolean arr[];
    public LUPrefix(int n) {
        this.n = n;
        endPoint = 0;
        arr = new boolean[n+1];
    }
    
    public void upload(int video) {
        arr[video] = true;
        while(endPoint<n && arr[endPoint+1])
            endPoint++;
    }
    
    public int longest() {
        return endPoint;
    }
}
