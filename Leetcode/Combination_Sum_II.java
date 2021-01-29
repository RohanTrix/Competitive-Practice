class Solution {
    //Refer https://www.youtube.com/watch?v=j9_qWJClp64
    //Coded Myself
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        int n = cand.length;
        int startIndex = 0; // Determines to start taking elements one by one from this i                                  index onwards
        Arrays.sort(cand);
        Set<List<Integer>> result = new HashSet<>(); // Stores final result
        backtrack(cand, startIndex,new ArrayList<Integer>(), result, target);
        //System.out.println(result);
        return new ArrayList<>(result);
    }
    private void backtrack(int cand[], int startIndex,
                          ArrayList<Integer> currList, Set<List<Integer>> result, int target)
    {
        //System.out.println(startIndex+" "+currList+" "+target);
        if(target<0) return;
        if(target==0)
        {
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        for(int ind = startIndex; ind<cand.length; ind++)
        {
            if(cand[ind]>target)
            {
                return;
            }
            currList.add(cand[ind]);
            backtrack(cand,ind+1,currList, result, target- cand[ind]);
            currList.remove(currList.size() -1); // To remove current index's element in                 array so that the index+1 array can be chosen for backtrack
            
        }
    }
}