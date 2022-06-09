
/*
    // REFER : https://youtu.be/s4GyrzuXUZA (Idea from here but own implementation done)
    IDEA : Its a great problem involving lots of good concepts. Solved in O(n).

           We want to find 2 non overlapping subarrays. We can reuse the idea of another problem
           of finding whether a subarray of sum k is present or not. We will map the prefix sum
           to a latest index on which this prefix sum was seen. This will not only help us get the 
           first subarray of sum target, but also it will be the shortest.

           Now, lets define predecessor[] and successor[] of an element. Predecessor of i is 
           the closest index behind it which makes a subarray of target with i. Now a cool
           observation is that if predecessor[i] = j, then similarly the successor of j is i
           which is the closest index after j which forms a sub array of sum target.

           Now some predecessors and successors can be undefined, for that we keep INF.
           Now, if we traverse at every i, and let subarray ending at i (whose start point is given by predecessor[i])
           be our first subarray. Now we need to choose the shortest subarray after i. This can be done by checking all successors[p]
           and taking min of lengths.
           where p is an index from i to n(i is included becase prefix sum left index is always 1 less than the left).
           
           But then that will become n^2. That is where suffixMin comes in. We keep suffix min of shortest subarray lengths
           from ith.

*/
public class Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum
{
    int INT_MAX = Integer.MAX_VALUE/2;
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int n = arr.length, currSum = 0;
        int predecessor[] = new int[n];
        int successor[] = new int[n];
        
        Arrays.fill(predecessor, INT_MAX);
        Arrays.fill(successor, INT_MAX);
        
        for(int i = 0; i<n; i++)
        {
            currSum+=arr[i];
            if(map.containsKey(currSum-target))
            {
                predecessor[i] = map.get(currSum-target);
                if(predecessor[i]!=-1) successor[map.get(currSum-target)] = i;
            }
            map.put(currSum, i);
        }
        
        int suffMin[] = new int[n];
        suffMin[n-1] = successor[n-1] == INT_MAX?INT_MAX:1;
        for(int i = n-2; i>=0; i--)
        {
            if(successor[i]!=INT_MAX)
                suffMin[i] = Math.min(successor[i] - i, suffMin[i+1]);
            else
                suffMin[i] = suffMin[i+1];
            
        }
        int prefMin[] = new int[n];
        prefMin[0] = predecessor[0]==INT_MAX?(INT_MAX):1;
        for(int i = 1; i<n; i++)
        {
            if(predecessor[i] ==  INT_MAX)
                prefMin[i] = prefMin[i-1];
            else
                prefMin[i] = Math.min(prefMin[i-1], i - predecessor[i]);
        }
        int mini = INT_MAX;
        for(int i = 0; i<n; i++)
        {
            if(prefMin[i] == INT_MAX || suffMin[i] == INT_MAX) continue;
            mini = Math.min(prefMin[i] + suffMin[i], mini);
        }
        // System.out.println(Arrays.toString(predecessor));
        // System.out.println(Arrays.toString(successor));
        return mini==INT_MAX?-1:mini;
    }
}