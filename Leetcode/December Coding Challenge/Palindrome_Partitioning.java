class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        findAll(s, result, new ArrayList());
        return result;
    }
    void findAll(String s, List<List<String>> result, List<String> temp)
    {
        if(s.length()==0)
            result.add(new ArrayList(temp));
        
        for(int i=0;i<s.length();i++)
        {
            String leftPart = s.substring(0,i+1);
            if(isPalin(leftPart))
            {
                temp.add(leftPart);
                findAll(s.substring(i+1), result, temp); // RIGHT PARTITION CALL
                temp.remove(temp.size()-1);
            }
        }
    }
    boolean isPalin(String s)
    {
        int left =0, right = s.length()-1;
        if(left==right) return true;
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}


// Eaiser solution using Catalan Numbers exist, however, recursive implementation is good for learning