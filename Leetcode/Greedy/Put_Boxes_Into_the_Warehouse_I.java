import java.util.Arrays;

/**
 * IDEA :
 * The key intuition is to place each box as far to the right as possible in the
 * warehouse, given the remaining space and box/warehouse heights. This
 * maximizes the remaining space for subsequent boxes.
 * We create a prefMin[] so that we are know the rightmost position that we can
 * fit a box in.
 * 
 * Sorting the boxes from shortest to tallest ensures we place smaller boxes
 * first, leaving maximum space for larger boxes later.
 * 
 * We want to traverse from the end of the prefMin so that we stop when we
 * land on the farthest position where our current box can be fitted into.
 * Sice all boxes after this will be >= current box, they will definetly lie
 * leftwards of my current position.
 * 
 * This greedy approach works because once a box is placed optimally, we don't
 * need to revisit it.
 * At each step, we make the optimal local decision (pushing the current box as
 * far right as possible).
 * 
 * 
 */
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int w = warehouse.length;
        int prefMin[] = new int[w];
        prefMin[0] = warehouse[0];
        for (int i = 1; i < w; i++)
            prefMin[i] = Math.min(prefMin[i - 1], warehouse[i]);
        int j = w - 1, cnt = 0;
        for (int box : boxes) {
            while (j >= 0 && prefMin[j] < box)
                j--;
            if (j >= 0) {
                cnt++;
                j--;
            }
        }
        return cnt;
    }
}