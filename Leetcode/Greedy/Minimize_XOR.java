public class Minimize_XOR {
    // IDEA : To minimize XOR, we want to do 1^1 to make it 0....and since the leftwards digits have higher weightage in making
    //        number greater, hence they should be handled first....If after doing that, we have some bits left,
    //        then we are left with no choice but to do 1^0 to the remaining bits....but we can minimize our number
    //        by taking the rightmost 0 bits
    public int minimizeXor(int num1, int num2) {
        int cnt = Integer.bitCount(num2);
        int x = 0;
        int arr[] = new int[32];
        for(int j = 30; j>=0;j--)
        {
            if((num1&(1<<j))!=0 && cnt>0)
            {
                x|= 1<<j;
                cnt--;
            }
        }
        int i = 0;
        while(cnt>0)
        {
            if((x&(1<<i))==0)
            {
                x|= 1<<i;
                cnt--;
            }
            i++;
        }
        return x;
    }
}
