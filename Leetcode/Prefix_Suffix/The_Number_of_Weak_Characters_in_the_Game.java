/**
 *      IDEA : Sorting should be the first idea since that fixes a particular ordering. So we SORT the
 *             array based on ATTACK. Now, if I am at ith player...all the attacks of ith ---> nth will be
 *             >= attack of ith player in ascending order. I can use a 2 pointer logic to keep track of the
 *             first player after ith which has an attack STRICTLY more than ith. 
 * 
 *             Now, we want to add to our answer if for any of these players between j...n have a
 *             DEFENSE more than ith. So basically by only checking if the MAX of these defenses is more than
 *             ith's DEFENSE....then ith is A WEAK CHARACTER.
 * 
 *             The two pointer logic helps to keep track in O(n) the index of the first person
 *             with ATTACK more than ith (this is also useful since the suffix becomes larger which might
 *             contain a larger MAX)
 * 
 */
public class The_Number_of_Weak_Characters_in_the_Game {
    public int numberOfWeakCharacters(int[][] props) {
        Arrays.sort(props, (a,b) -> a[0] - b[0]);
        int n = props.length;
        int suffMax[] = new int[n];
        suffMax[n-1] = props[n-1][1];
        for(int i = n-2; i>=0; i--)
            suffMax[i] = Math.max(suffMax[i+1], props[i][1]);

        int j = n;
        int cnt = 0;
        for(int i = n-2; i>=0; i--)
        {
            int A = props[i][0], D = props[i][1];
        
            while(props[j-1][0] > A) // Makes j the index of the first element after ith having strictly greater attack
                j--;
            if(j == n) continue;
            if(suffMax[j] > D) cnt++; // If the MAX DEFENSE in area j...n is also strictly greater than current's defense, then inc ans
        }
        return cnt;
    }
}
