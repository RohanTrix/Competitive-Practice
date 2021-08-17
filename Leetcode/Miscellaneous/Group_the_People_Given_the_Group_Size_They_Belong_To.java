package Leetcode.Miscellaneous;
import java.util.*;
public class Group_the_People_Given_the_Group_Size_They_Belong_To {
    public List<List<Integer>> groupThePeople(int[] gs) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i  = 0; i<gs.length; i++)
        {
            ArrayList<Integer> temp = hm.getOrDefault(gs[i], new ArrayList<>());
            temp.add(i);
            hm.put(gs[i], temp);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i : hm.keySet())
        {
            int size = 0;
            int ind = 0;
            List<Integer> curr = new ArrayList<>();
            while(ind<hm.get(i).size())
            {
                curr.add(hm.get(i).get(ind++));
                size++;
                if(size==i)
                {
                    res.add(new ArrayList<>(curr));
                    curr.clear();
                    size = 0;
                }
            }
        }
        return res;
    }
}
