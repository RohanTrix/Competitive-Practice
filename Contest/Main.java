import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the data: ");
        int n = sc.nextInt();
        int r = 0;
        while(Math.pow(2,r) < n+r+1)
        {
            r++;
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i<=r; i++)
            list.add(new ArrayList<>());
        for(int i = 1; i<(1<<(r)); i++)
        {
            for(int j = 0; j<r; j++)
            {
                if((i&(1<<j))!=0)
                {
                    list.get(j).add(i);
                }
            }
        }
        
    }
}