public classs Gas_Station
{
    // We can use a Two Pointer logic here. Since the problem is about a circular path in the array
    // it is better and safe to duplicate the array to make it of 2*n length.
    // We maintain a haveGas variable denoting the gas we have for reaching the next element.
    // We keep moving the right pointer until as long as we have gas>=0 and checking if we are at
    // n distance from the left. If gas at any time becomes negative, then we have to update 
    // our starting position(left variable) and re init the gas to zero
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gases[] = new int[2*n]; for(int i =0; i<2*n; i++) gases[i] = gas[i%n];
        int haveGas = 0, left = 0;
        int maxi = 0, start = -1;
        for(int right = 0; right<2*n; right++)
        {
            haveGas+=gases[right] - cost[right%n];
            
            if(haveGas<0)
            {
                haveGas = 0;
                left = right+1;
                continue;
            }
            if(right-left+1 == n) start = left;
        }
        return start;
    }
}