public class Corporate_Flight_Bookings
{
    // Partial Sums
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int pref[] = new int[n+2];
        for(int booking[]: bookings)
        {
            pref[booking[0]]+=booking[2];
            pref[booking[1]+1]-=booking[2];
        }
        for(int i = 1; i<=n; i++) pref[i]+=pref[i-1];
        int res[] = new int[n];
        for(int i = 1;i<=n; i++) res[i-1] = pref[i];
        return res;
    }
}