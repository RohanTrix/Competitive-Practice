class RandomizedCollection {
    // Idea similar to same question without duplicates. Just here we map val -> set of indices
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random r;
    public RandomizedCollection() {
        map = new HashMap<>(); // map val -> set of idxs in list having this val
        list = new ArrayList<>(); // list of elements ..useful for random selection
        r = new Random();
    }
    
    public boolean insert(int val) {
        /**
         *      1) Check if key in hashmap or not..if not then we return true since it is the first time element is being added
         *      2) Add val to end of list...and add idx of list's end to the set corresponding to this val in the map
         */
        boolean res = !map.containsKey(val);
        list.add(val);
        map.computeIfAbsent(val, k->new HashSet<>()).add(list.size()-1);
        return res;
    }
    
    public boolean remove(int val) {
        
        /**
         *      1) Check if key in hashmap or not..if not then we return false
         *      2) Else. do the following.
         *      3) Get the set corresponding to the val asked to remove.
         *      4) Using iterator, get one idx from which val can be removed.
         *      5) If idx == list's end, just remove the last element and return true.
         *      6) Else, we want to remove the last element in the list and overwrite it on idx. This also means we should remove the the 
         *         list's end idx from the set corresponding to the lastElement and add this new index to this set. 
         */
        if(!map.containsKey(val))
            return false;
        Set<Integer> set = map.get(val);
        int idx = set.iterator().next();
        set.remove(idx);
        if(set.isEmpty())
            map.remove(val);
        if(idx == list.size()-1)
            list.remove(list.size()-1);
        else
        {
            int lastElement = list.get(list.size() - 1);
            map.get(lastElement).remove(list.size()-1);
            list.remove(list.size()-1);
            list.set(idx, lastElement);
            map.get(lastElement).add(idx);
        }
        return true;
    }
    
    public int getRandom() {
        // Generate random index and return its elememt;
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */