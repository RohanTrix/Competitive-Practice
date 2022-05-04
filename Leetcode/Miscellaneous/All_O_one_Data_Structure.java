package Leetcode.Miscellaneous;

/*
    IDEA : One TreeMap and one HashMap based log n solution.
           cntmap ---- frequency -> list of strings having that frequency
           strmap ---- string -> current freuqency
*/

public class All_O_one_Data_Structure {
    TreeMap<Integer, Set<String>> cntmap;
    Map<String, Integer> strmap;
    int mini = 0, maxi = 0;
    public AllOne() {
        cntmap = new TreeMap<>();
        strmap = new HashMap<>();
    }
    
    public void inc(String key) {
        if(!strmap.containsKey(key))
        {
            strmap.put(key, 1);
            cntmap.computeIfAbsent(1, k -> new HashSet<>()).add(key);
            return;
        }
        int cnt = strmap.get(key);
        cntmap.computeIfAbsent(cnt+1, k -> new HashSet<>()).add(key);
        cntmap.get(cnt).remove(key);
        if(cntmap.get(cnt).size()==0)
            cntmap.remove(cnt);
        strmap.put(key, cnt+1);
        // System.out.println(cntmap);
    }
    
    public void dec(String key) {
        cntmap.get(strmap.get(key)).remove(key);
        if(cntmap.get(strmap.get(key)).size()==0)
            cntmap.remove(strmap.get(key));
        strmap.put(key,strmap.get(key)-1);
        if(strmap.get(key) == 0)
            strmap.remove(key);
        else
            cntmap.computeIfAbsent(strmap.get(key), k -> new HashSet<>()).add(key);
        
    }
    
    public String getMaxKey() {
        try{
            return cntmap.get(cntmap.lastKey()).iterator().next();
        }
        catch(Exception e)
        {
            return "";
        }
    }
    
    public String getMinKey() {
        try{
            return cntmap.get(cntmap.firstKey()).iterator().next();
        }
        catch(Exception e)
        {
            return "";
        }
    }
}
