public class Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    // REFER : https://youtu.be/wxqN1HX4Djk
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        for (int i = 0; i < n; i++)
            time[i] = time[i] % 60;

        int freq[] = new int[60];
        for (int i = 0; i < n; i++)
            freq[time[i] % 60]++;

        int cnt = 0;
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30)
                cnt += (freq[i] * (freq[i] - 1)) / 2;
            else
                cnt += freq[i] * freq[60 - i];
        }
        return cnt;
    }
}
