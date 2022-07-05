/**
 *      IDEA : We create a BIT/Fenwick array of length m + q + 1.
 *             We will simulate the process over this BIT array...Initially all elements 1,2,3,4... are placed at idx q+1,q+1,q+3....
 *             To denote that an element is placed, we mark it with 1.
 *             We also maintain a MAP `val_to_pos`...that maps the value to its latest position in the BIT array.
 *             The BIT array will be used to get the count of elements (using sum) between [0..r].
 *             NOTE: THE INDEX OF AN ELEMENT IS BASICALLY THE NO. OF ELEMENTS BEFORE IT.
 * 
 *             Here is the flow : 1) Initally...array elements [q+1...q+m] have 1 in them denoting there is an element here.
 *                                   Also...val_to_pos contains the mapping of val to the index in BIT array
 *                                
 *                                2) For each query, 
 *                                      a) we find its latest index in the BIT array
 *                                      b) Find Count of elements before this idx
 *                                      c) Then using update(pos, -1), we remove the value from this idx
 *                                      d) Then using update(nextInd, 1), we denote a value at front of all elements
 *                                          ....nextInd goes from q -> 1
 *                                      e) We also update the new position of this query value in hashmap
 *                                  
 * 
 * 
 */
public class Queries_on_a_Permutation_With_Key
{
    private class Fenwick
    {
        int bit[];
        int size;
        public Fenwick(int n)
        {
            size = n-1;
            bit = new int[n];
        }
        public void update(int pos, int val)
        {
            while(pos<=size)
            {
                bit[pos]+=val;
                pos+=Integer.lowestOneBit(pos);
            }
        }
        public int sum(int pos) // sum from [1,pos]
        {
            int sum = 0;
            while(pos>0)
            {
                sum+=bit[pos];
                pos-=Integer.lowestOneBit(pos);
            }
            return sum;
        }
    }
    public int[] processQueries(int[] queries, int m) {
        int q = queries.length;
        Fenwick ft = new Fenwick(m+q+1);
        Map<Integer, Integer> val_to_pos = new HashMap<>();
        for(int i = 1; i<=m; i++)
        {
            ft.update(q+i, 1); // Mark that element is present here
            val_to_pos.put(i, q+i); // Save the idx for val=i in the val_to_pos map
        }
        int nextInd = q; // This points to the next position where element can be placed in front.
        for(int qq = 0; qq<q; qq++)
        {
            int qval = queries[qq];
            int idx = val_to_pos.get(qval); // Latest idx of query value
            queries[qq] = ft.sum(idx-1); // Find no. of elements before it...this denotes its actual idx in the imaginary array
            ft.update(idx,-1); // Remove element from current idx
            ft.update(nextInd,1); // Add element to front of the array...the front is denoted using nextInd
            val_to_pos.put(qval, nextInd); // Update the new position for the query value
            nextInd--; // Update the next front idx where the element will be placed
        }
        return queries; // Ans is reassigned and saved in queries.
    }
}