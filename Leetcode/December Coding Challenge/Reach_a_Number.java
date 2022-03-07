public class Reach_a_Number
{
    // REFER : https://youtu.be/kz_0GjhFOzc
    public int reachNumber(int target) {
        int moves = 0;
        int sum = 0;
        target = Math.abs(target);
        while(sum<target)
        {
            moves++;
            sum+=moves;
        }
        
        while((sum - target)%2!=0)
        {
            moves++;
            sum+=moves;
        }
        return moves;
    }
}