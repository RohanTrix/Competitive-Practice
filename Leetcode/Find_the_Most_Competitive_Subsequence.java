package Leetcode;

import java.util.*;

public class Find_the_Most_Competitive_Subsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i< nums.length; i++)
        {
             while (!s.empty() && (nums[i] < s.peek()) && (nums.length - i + s.size() - 1) >= k) 
             {
                // s.empty() should be false so that popping can be done
                // nums[i] < s.peek() means that current element is smaller than the last element in stack
                // nums.length - i (no. elements after the current element) + s.size() - 1 ( no. of elements after                     removing last element) SHOULD BE MORE THAN EQUAL TO k so that our subsequence size can be still                     formed
                    s.pop();
              }
            
              if(s.size() < k)
                  s.add(nums[i]);
        }
        
        int result[] = new int[k];
        for(int i = k-1; i>=0; i--)
            result[i] = s.pop();
        
        return result;
        
    }
    
}
