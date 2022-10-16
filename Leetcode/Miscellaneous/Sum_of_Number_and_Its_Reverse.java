public class Sum_of_Number_and_Its_Reverse {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i = 0; i<=num; i++)
        {
            if(i + Integer.valueOf(new StringBuilder(""+i).reverse().toString()) == num)
                return true;
        }
        return false;
    }
}
