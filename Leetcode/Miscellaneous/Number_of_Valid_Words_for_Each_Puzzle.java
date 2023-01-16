import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *      IDEA : The hint is in the constraints!! The length of each puzzle is only 7 and 2^7 is only 128.
 *             
 * 
 *              Observations : If we look at condition 2, it is basically asking if word is a subset of charset of a puzzle or not.
 *                             To handle these situation, bitmasks are the best.
 *              
 *              So firstly you would think: For each puzzle -> for each word -> if mask(word) is submask of mask(puzzle), then ADD 1 to answer of this puzzle
 *              But the T.C by doing this would become at least (10^5 * 10^4).
 *              We need to remove either 10^4 or 10^5. We can use a hashmap and store a FREQUENCY MAP for masks-> # of words having that mask
 * 
 *              Now, since each puzzle has at max 128 bitmasks....we can basically enumerate on the submasks of each bitmask(of the puzzle).
 *              For each submask, if that submask is present in the hashmap, then the map will give us the count of the words that have their mask = submask
 *              Accumulate all for puzzle[i] ans.
 */


public class Number_of_Valid_Words_for_Each_Puzzle{
    public int getMask(String s)
    {
        int mask = 0;
        for(char ch : s.toCharArray())
                mask|=1<<(ch-'a');
        return mask;
    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for(String word : words)
        {
            int mask = getMask(word);
            map.put(mask, map.getOrDefault(mask, 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(String puzz : puzzles)
        {
            int res = 0, mask = getMask(puzz);
            for(int sub = mask; sub>0; sub = (sub - 1)&mask) // Submask Enumeration 
                if((sub & (1<<(puzz.charAt(0) - 'a'))) !=0) // 
                    res+=map.getOrDefault(sub, 0);
            list.add(res);
        }
        return list;
    }
}