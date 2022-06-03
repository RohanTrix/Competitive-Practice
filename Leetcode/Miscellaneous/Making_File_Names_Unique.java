public class Making_File_Names_Unique {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        
        String res[] = new String[names.length];
        int i = 0;
        for(String name : names)
        {
            if(!map.containsKey(name))
            {
                res[i++] = name;
                map.put(name, 1);
            }
            else
            {
                String newName = name+"("+map.get(name)+")";
                while(map.containsKey(newName)){
                    map.put(name, map.get(name)+1);
                    newName = name+"("+map.get(name)+")";
                }
                map.put(newName, 1);
                res[i++] = newName;
            }
        }
        return res;
    }
}
