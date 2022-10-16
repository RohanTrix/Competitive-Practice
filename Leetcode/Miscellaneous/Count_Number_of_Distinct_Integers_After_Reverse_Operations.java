public class Count_Number_of_Distinct_Integers_After_Reverse_Operations {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            set.add(num);
            set.add(Integer.valueOf(new StringBuilder(""+num).reverse().toString()));
        }
        return set.size();
    }
}
