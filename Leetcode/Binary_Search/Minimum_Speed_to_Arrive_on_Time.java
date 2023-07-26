public class Minimum_Speed_to_Arrive_on_Time {
    public boolean possible(int speed, int dist[], double hour) {
        double tot = 0.0;
        for(int i = 0; i<dist.length-1; i++) {
            int d = dist[i];
            int time = (d+speed-1)/speed; // Ceil
            tot+=time;
        }
        tot+=(1.0*dist[dist.length-1])/(1.0*speed); // Last distance does not need to be rounded up
                                                    // since we are not going to wait for the next train
        return tot<=hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = (int)1e8, ans = -1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(possible(mid, dist, hour)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
}
