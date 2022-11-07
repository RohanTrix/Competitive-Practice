/**
 *      IDEA : Segment Tree might come to the mind, but is really unneccesary if we simulate it in a good way since we only require prefix and suffix mininum.
 *             Instead, 2 PQ has been used...one for start side and another for ending side. 
 *             The only careful implementation we need to do in this is to be careful that the elements of the 2 PQ are always disjoint.
 * 
 *             I put the first `cand` elements in the pq1 and the last `cand` elements(uptil the part where they do not overlap with pq1) in pq2.
 *             Now, the greedy logic is, we check the minimum from pq1 and pq1....whichever has minimum...we add the cost to the answer
 *             and poll from that pq. and then we update the l,r boundaries
 *             
 *             Finally a time will come when array has less than 2*cand elements, means l==r...so now, since taking mini from first k and last k are having overlap 
 *             this basically means we can take minimum of remaining array everytime. So we transfer all elements from pq2 to pq1...and fill minimum from pq
 * 
 * 
 * 
 */


public class Total_Cost_to_Hire_K_Workers {
    public long totalCost(int[] costs, int k, int cand) {
        int n = costs.length;
        PriorityQueue<Item> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        int l = cand - 1, r = n - cand;
        for (int i = 0; i < cand; i++)
            pq1.offer(new Item(costs[i], i));
        for (int i = n - 1; i >= n - cand && i >= cand; i--)
            pq2.offer(new Item(costs[i], i));

        long ans = 0;
        while (l < r && k > 0) {
            Item left = pq1.peek(), right = pq2.peek();
            if (left.cost <= right.cost) {

                ans += left.cost;
                pq1.poll();
                l++;
                if (l < r)
                    pq1.offer(new Item(costs[l], l));
            } else {
                ans += right.cost;
                pq2.poll();
                r--;
                if (l < r)
                    pq2.offer(new Item(costs[r], r));
            }
            k--;
        }
        while (!pq2.isEmpty())
            pq1.offer(pq2.poll());
        while (k > 0) {
            ans += pq1.poll().cost;
            k--;
        }
        return ans;
    }

    class Item implements Comparable<Item> {
        int cost, ind;

        public Item(int c, int i) {
            this.cost = c;
            this.ind = i;
        }

        public int compareTo(Item that) {
            if (this.cost == that.cost)
                return this.ind - that.ind;
            return this.cost - that.cost;
        }
    }
}
