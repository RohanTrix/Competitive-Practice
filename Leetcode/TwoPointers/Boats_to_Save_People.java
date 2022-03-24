/* 
    IDEA : We want to get rid of the higher weighted persons first. But if along with that we have some
           space left, it would be a good idea to fit a small weighted person(if possible).
           So we can keep 2 pointers after sorting the array. Everytime, we want to definetly put highest weighted
           person on a boat, but if the lowest weighted person can be sent with him, we do that too.

           The reason why this works: Imagine 2 cases: limit is quite high and limit is quite low
                                      Once you put the large weighted person, if the limit is quite high,
                                      you could have also put another high weighted person. But still you would
                                      have anyways required one more boat for the low weighted person.
                                      If the limit was low, you would have put low weighted person and needed another
                                      boat for next higher person.

                                      Moreover, if you are able to place a 2nd higher weighted person on the same
                                      boat, you anyways can place a lower weighted person instead. But not vice-versa
*/

public class Boats_to_Save_People
{
    public int numRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        int boats = 0;
        int left = 0, right = nums.length-1;
        while(left<right)
        {
            if(nums[left]+nums[right]<=limit)
            {
                boats++;
                left++; right--;
            }
            else
            {
                boats++;
                right--;
            }
        }
        if(left == right) boats++;
        return boats;
    }
}