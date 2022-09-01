public class Random_Pick_with_Weight {
    // REFER : https://youtu.be/4vNzd2kmfCc
    int pref[], max;
    Random r;
    public Solution(int[] w) {
        pref = new int[w.length+1];
        for(int i = 0; i<w.length; i++)
            pref[i+1]+=pref[i]+w[i];
        r = new Random();
        max = pref[w.length];
    }
    
    public int pickIndex() {
        int key = r.nextInt(max);
        int left = 0, right = pref.length-1;
        int ans = -1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(pref[mid]<=key)
            {
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return ans;
    }
}
