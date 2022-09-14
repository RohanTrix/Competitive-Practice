/*
 *  IDEA : Maintaining a prefix product can help us get the Product of any subarray...so easily we can get
 *         product of a suffix of last k numbers by PROD(N-1) / PROD(N-1 - K)
 * 
 *         The only tricky case is the occurence of 0. The occurence of 0 brings a big issue since then 
 *         the prefix product fails and leaves you with a division by 0 error. So the good thing
 *         about this problem is that it onlys asks you to find the prefix product...So,
 *         everytime our prefix becomes 0 (because of latest element as 0), we will reset the list.
 * 
 *         The intuition behind this is, now..if left boundary lies on or behind a 0 element, then by our previous logic,
 *         that index will a -ve index....So if the left boundary is a -ve index, the product is 0.
 *         We can also say we keep track of the non-zero prefix product;
 */


public class Product_of_the_Last_K_Numbers
{
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        list.add(list.get(list.size()-1)*num);
        if(list.get(list.size() - 1) == 0)
        {
            list = new ArrayList<>();
            list.add(1);
        }
        
    }
    public int getProduct(int k) {
        int n = list.size();
        if(n-1-k < 0)
            return 0;
        return list.get(n - 1)/list.get(n - 1 - k);
    }
}