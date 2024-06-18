import java.util.Arrays;

/**
 * IDEA : According to version 1 of the problem, we could find the
 * farthest positon to insert a box by using a prefMin and a pointer that
 * traverses from the end.
 * 
 * Now, we have 2 ends to push from. Hence, imagine a prefMin and a suffMin.
 * Thus, every position has a maximum allowed height from left and right each.
 * 
 * For every position, we choose MAX(leftMin, rightMin) since we will choose to
 * shift a box from that end which gives us a larger height.
 * Here's a simplified way to look at it:
 * 
 *          > If you push a box from the left, it must pass through all rooms from the left
 *          up to its position.
 *          > If you push a box from the right, it must pass through all rooms from the
 *          right up to its position.
 *          > For a box to reach room i, it should be able to pass through the more
 *          permissive height constraint from either direction.
 * 
 * We sort both boxes and bestHeights since we want to try and greedily place the smallest box
 * to the smallest warehouse that fits it. We can do this by simple 2 pointers or as shown in code.
 * 
 * 
 */
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int w = warehouse.length;
        int prefMin[] = new int[w];
        int suffMin[] = new int[w];

        prefMin[0] = warehouse[0];
        for (int i = 1; i < w; i++)
            prefMin[i] = Math.min(prefMin[i - 1], warehouse[i]);

        suffMin[w - 1] = warehouse[w - 1];
        for (int i = w - 2; i >= 0; i--)
            suffMin[i] = Math.min(suffMin[i + 1], warehouse[i]);

        int bestHeightFromBothEnds[] = new int[w];
        for (int i = 0; i < w; i++)
            bestHeightFromBothEnds[i] = Math.max(prefMin[i], suffMin[i]);

        Arrays.sort(boxes);
        Arrays.sort(bestHeightFromBothEnds);
        int k = 0, cnt = 0;
        for (int box : boxes) {
            while (k < w && box > bestHeightFromBothEnds[k])
                k++;
            if (k < w && box <= bestHeightFromBothEnds[k]) {
                cnt++;
                k++;
            }
        }
        return cnt;
    }
}