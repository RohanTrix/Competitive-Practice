public class Lexicographical_Numbers
{
    List<Integer> list;
    public void recur(int num, int n)
    {
        if(num > n) return;
        list.add(num);
        for(int d = 0; d<10; d++)
            recur(num*10+d, n);
    }
    public List<Integer> lexicalOrder(int n) {
        list = new ArrayList<>();
        for(int i = 1; i<10; i++)
            recur(i,n);
        return list;
    }
}