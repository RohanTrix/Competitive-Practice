public class Repeated_DNA_Sequences {
    // IDEA : Since str length is only 10, ..the complexity of this program is O(10n)
    public List<String> findRepeatedDnaSequences(String s) {
        // Checking duplicates for every 1- length substring
        int n = s.length();
        Set<String> hs = new HashSet<>();
        Set<String> ansSet = new HashSet<>();
        for(int i = 0; i<n-10+1;i++)
        {
            if(hs.contains(s.substring(i,i+10)))
                ansSet.add(s.substring(i,i+10));
            hs.add(s.substring(i,i+10));
                
        }
        return new ArrayList<>(ansSet);
    }
}
