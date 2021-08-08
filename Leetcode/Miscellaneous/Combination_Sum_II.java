package Leetcode.Miscellaneous;
import java.util.*;
class Combination_Sum_II {
    //Refer https://www.youtube.com/watch?v=j9_qWJClp64
    //Coded Myself----Draw bactracking/recursion tree
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
        
        if(target==0) // We have reached our goal and the currList can be added to final                                result
        {
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        for(int ind = startIndex; ind<cand.length; ind++) // 
        {
            if(cand[ind]>target)  return;
            // Since smaller target cant be made from bigger number,                                       and as we have sorted the array, so no values after                                         index 'ind' will help making target
            
            
            
            currList.add(cand[ind]);// Adding current number to list
            backtrack(cand,ind+1,currList, result, target- cand[ind]); // Backtracking
            currList.remove(currList.size() -1); // Removing current index's element from                                                       currList so that the index+1 array can                                                       be chosen for backtrack
            
        }
    }
}