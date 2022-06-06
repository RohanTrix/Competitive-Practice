package Leetcode.Miscellaneous;

/*
    IDEA : We use a HashMap and a ArrayList. The hashmap maps the value to the index it is stored in the arraylist

            1) For insertion, we insert the element to the list's end and 
                add the (value-> last index) in the map
            
            2) For removal, we can do this in O(1) by removing the last element and ovewriting it on the position
               of the element to be removed. We also update the new idx of this lastElement in the map. And of course remove the
               value queried from the map.

            3) For random value, We choose a random index of the list and return the value present there.
*/
public class Insert_Delete_GetRandom_O1 {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        map.remove(val);
        int lastElement = list.remove(list.size()-1);
        if(idx == list.size())
            return true;
        else
        {
            map.put(lastElement, idx);
            list.set(idx, lastElement);
            return true;
        }   
    }
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
        
    }
}
