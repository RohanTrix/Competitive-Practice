public class Maximum_Score_Of_Spliced_Array {
    // LOGIC : https://youtu.be/U2lEnJLqaeo
    public int maxScore(int nums1[], int nums2[])
    {
        int orgsum = 0;
        for(int num : nums1) orgsum+=num;
        int n = nums1.length;
        int pref1 = 0, pref2 = 0;
        int minDiff = 0;
        int maxGain = orgsum;
        for(int i = 0; i<n; i++)
        {
            pref1+=nums1[i];
            pref2+=nums2[i];
            int diff = pref2 - pref1;
            int gain = diff + minDiff;
            maxGain = Math.max(maxGain, orgsum + gain);
            minDiff = Math.max(minDiff, pref1 - pref2);
        }
        return maxGain;
    }
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(maxScore(nums1, nums2), maxScore(nums2.clone(), nums1.clone()));
    }
}
