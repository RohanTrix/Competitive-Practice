public class Minimum_Number_of_Operations_to_Reinitialize_a_Permutation
{
    // Simulation
    public int reinitializePermutation(int n) {
        List<Integer> curr = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        for(int i =0; i<n; i++) curr.add(i);
        int cnt = 0;
        boolean same;
        do
        {
            for(int i = 0; i<n; i++)
            {
                if(i%2==0)
                    next.add(curr.get(i/2));
                else
                    next.add(curr.get(n/2 + (i-1)/2));
            }
            cnt++;
            // System.out.println(curr);
            // System.out.println(next);
            same = true;
            for(int i = 0; i<n; i++)
                same = same && next.get(i) == i;
            curr = new ArrayList<>(next);
            next.clear();
        }while(!same);
        return cnt;
    }
}