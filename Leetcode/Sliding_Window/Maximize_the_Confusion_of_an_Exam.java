package Leetcode.Sliding_Window;

/*
 *      IDEA : Once we will try to convert on T->F..and once vice versa
 *             We basically want to find longest subtring with same consecutive letter given
 *              we can change char `key` upto k times
 *             QUESTION IS SAME AS MAX CONSECUTIVE ONES III but here we can either change T to F ro vice versa.
 *             So answer is basically max of the 2.
 */


public class Maximize_the_Confusion_of_an_Exam {
    public int longest(char ans[], char key, int k)
    {
        int left = 0;
        int n = ans.length;
        int sum = 0, maxi = Integer.MIN_VALUE;
        for(int right = 0; right<n; right++)
        {
            sum++;
            if(ans[right] !=key) k--;
            while(left<right && k<0)
            {
                sum--;
                if(ans[left]!=key) k++;
                left++;
            }
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char ans[] = answerKey.toCharArray();
        return Math.max(longest(ans, 'T', k), longest(ans, 'F', k));
    }
}
