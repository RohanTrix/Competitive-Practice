class The_kth_Factor_of_n {
    public int kthFactor(int n, int k) {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        for(int i= (int)Math.sqrt(n);i>0;i--)
        {
            if(n%i==0)
            {
                if(i !=n/i){
                    arr.offerFirst(i);
                    arr.offerLast(n/i);
                }
                else
                    arr.offerFirst(i);
            }
        }
        //System.out.println(arr);
        ArrayList<Integer> al = new ArrayList<Integer>(arr);
        if( arr.size()<k)
            return -1;
        return al.get(k-1);
    }
}