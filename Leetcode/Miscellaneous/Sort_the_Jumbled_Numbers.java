public class Sort_the_Jumbled_Numbers
{
    int map[];
    // Function to return Integer value of String formed after changing digits to mapping digits
    public int changed(int a)
    {
        StringBuilder str =  new StringBuilder();
        char num[] = Integer.toString(a).toCharArray();
        
        for(int i = 0; i<num.length; i++) num[i] = (char)(map[num[i]-'0'] +'0');
        return Integer.valueOf(new String(num));
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        map = mapping;
        List<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);
        
        
        //for(int num : nums) System.out.println(changed(num));
        Collections.sort(list, (a,b) -> changed(a) - changed(b));
        
        for(int i = 0; i<list.size(); i++) nums[i] = list.get(i);
        return nums;
    }
}