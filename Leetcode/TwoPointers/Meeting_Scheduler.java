class Meeting_Scheduler {
    /**
     *      IDEA : We want to sort both slots1 and slots2 by the start time first,
     *      then initialize two pointers, each of which points to the beginning of the two arrays.
     *      From there, we will compare the two slots, and move one pointer at a time if the common slot
     *      is smaller than duration.
     *
     *      Here comes the question: how do we decide which pointer should be incremented?
     *
     * The answer is: we will always move the one that ends earlier.
     * Assuming that we are comparing slots1[i] and slots2[j] and slots1[i][1] > slots2[j][1], we would always choose to move the pointer j.
     * The reason is that, as both slots are sorted, if slots1[i][1] > slots2[j][1], we know slots1[i+1][0] > slots2[j][1]
     * so that there will be no intersection between slots1[i+1] and slots2[j].
     */
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int n1 = slots1.length, n2 = slots2.length;
        Arrays.sort(slots1, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a,b) -> Integer.compare(a[0], b[0]));
        int i = 0, j = 0;

        while(i < n1 && j < n2) {
            int slot1[] = slots1[i], slot2[] = slots2[j];
            int commonStart = Math.max(slot1[0], slot2[0]);
            int commonEnd = Math.min(slot1[1], slot2[1]);
            int commonDuration = commonEnd - commonStart;
            if(duration <= commonDuration)
                return List.of(commonStart, commonStart + duration);

            if(slot1[1] < slot2[1]) i++;
            else j++;
        }
        return List.of();
    }
}