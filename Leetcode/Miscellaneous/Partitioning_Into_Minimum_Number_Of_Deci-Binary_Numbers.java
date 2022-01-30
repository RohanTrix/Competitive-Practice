class Partitioning_Into_Minimum_Number_Of_Deci-Binary_Numbers {
    public int minPartitions(String n) {
        char s[] = n.toCharArray();
        int maxi = 0;
        for(char c : s)
        {
            maxi = Math.max(maxi, (c-'0'));
        }
        return maxi;
    }
}