public class Broken_Calculator
{
    public int brokenCalc(int startValue, int target) {
        // Going from target to startValue

        // Since we are doing reverse operations, we know that we can only divide if curr value is divisible by 2.
        // This is because, if we had gone in the forward direction, then on multiplying by 2, the no. becomes
        // a multiple of 2.
        // Moreover, If the currValue becomes lesser than the startValue, then we can only use add operation to reach
        // that value.
        int moves = 0;
        while(target!=startValue)
        {
            if(target<startValue)
            {
                moves+=startValue-target;
                break;
            }
            else if(target%2==0) 
                target/=2;
            else
                target++;
            moves++;
        }
        return moves;
    }
}