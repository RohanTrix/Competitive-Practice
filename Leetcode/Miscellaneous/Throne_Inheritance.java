/**
 *      IDEA : We need to maintain the following :
 *              Lets call birthtime as age
 *              1) dead (SET) -> Set of people who are now dead, so that we can check and not add to our final answer
 *              2) graph -> Graph being formed ....treeset used to sort it based on age
 *              3) ageMap -> Maps birth time/age -> name of the person
 *              4) nameMap -> Reverse map of ageMap
 *              
 *              We are using building graph on the age since it is easier and also allows sorting based on age
 * 
 *             Follow Comments for further explanation
 */
class ThroneInheritance {
    Set<Integer> dead;
    Map<Integer, TreeSet<Integer>> graph;
    Map<Integer, String> ageMap;
    Map<String, Integer> nameMap;
    int age;
    public ThroneInheritance(String kingName) {
        dead = new HashSet<>();
        graph = new HashMap<>();
        ageMap = new HashMap<>(); nameMap = new HashMap<>();
        age = 0;
        // Set king as the first node
        graph.put(0, new TreeSet<>());
        ageMap.put(0, kingName);
        nameMap.put(kingName, 0);
    }
    
    public void birth(String parentName, String childName) {
        
        age++; // Increase the age since this a new timestamp
        ageMap.put(age, childName); nameMap.put(childName, age);
        int parentAge = nameMap.get(parentName);
        graph.computeIfAbsent(parentAge, k-> new TreeSet<>()).add(age); // Add Edge in graph
    }
    
    public void death(String name) {
        dead.add(nameMap.get(name)); // Just add to dead set
    }
    public void dfs(int node, List<String> order)
    {
        if(!dead.contains(node)) // If the current node is not dead, we can add it to the answer
            order.add(ageMap.get(node));
        for(int to : graph.getOrDefault(node, new TreeSet<>()))
            dfs(to, order);
    }
    public List<String> getInheritanceOrder() {
        List<String> curr = new ArrayList<>();
        dfs(0, curr); // Perform dfs
        return curr;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */