class Solution {
    public double averageWaitingTime(int[][] cust) {
        int prevEnd = 1;
        int n = cust.length;
        double time=0;
        for(int i=0;i<n;i++)
        {
            time+=cust[i][1];
            if(prevEnd>cust[i][0]){
                time+=prevEnd-cust[i][0];
                prevEnd =prevEnd+cust[i][1];
                }
            else
            {
               prevEnd = cust[i][0]+cust[i][1];
            }
            System.out.println(prevEnd);
        }
        return time/n;
    }
}