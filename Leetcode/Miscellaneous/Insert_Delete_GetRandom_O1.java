package Leetcode.Miscellaneous;

/*
    IDEA : We use a HashMap and a ArrayList. The hashmap maps the value to the index it is stored in the arraylist

            1) For insertion, we insert the element to the list's end and 
                add the (value-> index) in the map
            
            2) For removal, we decrease the index of all the elements after the one the to be removed,
               should be decreased by one. then we remove the element from the list and the map.

            3) For random value, We choose a random index of the list and return the value present there.
*/
public class Insert_Delete_GetRandom_O1 {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        for(int i =index+1; i<list.size(); i++)
        {
            int v = list.get(i);
            map.put(v, map.get(v)-1);
        }
        list.remove(index);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int min = 0, max = list.size()-1;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return list.get(random_int);
        
    }
}
