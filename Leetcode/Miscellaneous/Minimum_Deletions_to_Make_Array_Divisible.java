/**
 *      IDEA : The greatest no. that will divide every no. in nd[] array is the GCD of the array.
 *             
 *             Now, the smallest no. in nums should be a factor of GCD if it wants to divide nd array
 *             So basically we want to remove all numbers before it. So best to sort the array.
 *             And then we traverse nums and ans is all elements before the first num that is
 *             a factor of gcd. One edge case is that...no element is a factor of the gcd..in that case
 *             ans is -1.
 */
public class Minimum_Deletions_to_Make_Array_Divisible {
    public int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
    public int minOperations(int[] nums, int[] nd) {
        Arrays.sort(nums);
        int n = nums.length;
        int g = nd[0];
        for(int num : nd) g  =gcd(g, num);
        int cnt = 0;
        for(int num : nums)
        {
            if(g%num !=0) cnt++;
            else break;
        }
        return cnt == n?-1:cnt;
    }
}
