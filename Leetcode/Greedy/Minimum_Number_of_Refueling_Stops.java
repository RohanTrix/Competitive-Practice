/**
 *      IDEA : Let `maxReach` be the maximum pos we can reach ---  basically the amount of fuel we have consumed.
 *             Lets say we can reach a position X with the fuel we have right now. Now, there will be some stations that
 *             come on the way to this point X. If X < target, then we need to take a fuel tank from one of these stations that we have
 *             already passed. GREEDILY, we want to pick the station with the HIGHEST FUEL since it gives us the
 *             BEST CHANCE to reach our target. Again, if adding this fuel can take us to a distance Y ( Y < target)...then we need to
 *             consider some extra stations that may have come between X and Y....so how to choose the station with the most fuel
 *             everytime ??? ---> By Using a MAX PQ. Each time we want to increase our reach, we use the station with the max fuel
 *             
 * 
 *             Follow code to understand better
 * 
 */
public class Minimum_Number_of_Refueling_Stops
{
    // REFER : https://youtu.be/sKjKLN5JswQ
    public int minRefuelStops(int target, int startFuel, int[][] stats) {
        Arrays.sort(stats, (a,b) -> a[0] - b[0]); // sorting based on position
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max Prioirty Queue
        int k = 0, cnt = 0;
        int maxReach = startFuel;
        while(maxReach<target) // We repeat the process until we have enough fuel to REACH OR CROSS the target
        {
            // Keep adding stations to MAX PQ which are within our reach (maxReach)
            while(k<stats.length && stats[k][0] <= maxReach)
                pq.offer(stats[k++][1]);
            
            if(pq.isEmpty()) return -1; // If no more fuel tanks we can use...and we havent reached our target, so impossible
            
            cnt++; // Use 1 station
            maxReach+=pq.poll(); // Increase maxReach by the fuel amount
        }
        return cnt;
    }
}