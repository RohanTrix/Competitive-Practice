public class Number_of_Laser_Beams_in_a_Bank {
    // For every row, find no. of devices on it. For ith row, if it has devies,
    // Update your answer as no. of devices in last row which had devices * devices on ith row
    // Also update lastRow's value as current row's value
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int row[] = new int[n];
        int i =0;
        for(String s: bank)
        {
            for(char ch : s.toCharArray())
                row[i]+=ch-'0';
            i++;
        }
        int ans = 0;
        int lastRow = row[0];
        for(i = 1;i<n;i++)
        {
            if(row[i]==0) continue;
            ans+=(row[i]*lastRow);
            lastRow = row[i];
        }
        return ans;
    }
}
