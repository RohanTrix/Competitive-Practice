import java.io.*;
import java.util.*;
import myexceptionlist.ArrayFilledException;
@SuppressWarnings("all")
class Matrix
{
    int mat[][] = new int[6][6];
    Scanner sc = new Scanner(System.in);
    public Matrix()
    {
        for(int m[]:mat)Arrays.fill(mat, -1);
    }
    public synchronized void setPos(int val) throws ArrayFilledException
    {
        System.out.println("Enter row and column:");
        int r = sc.nextInt();
        int c = sc.nextInt();
        if(mat[r][c]!=-1)throw new ArrayFilledException("CELL ALREADY FILLED! TERI MAA KA BHOSRA");
        mat[r][c] = val;
    }
}
public class Main 
{

    public static void main(String[] args) 
    {
        Matrix obj = new Matrix();

        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                for(int i = 0; i<8; i++)
                {
                    obj.setPos(1);
                }
            }
        })

        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                for(int i = 0; i<8; i++)
                {
                    obj.setPos(2);
                }
            }
        })

        t1.start();
        t2.start();

        t1.run();
        t2.run();
        t1.join();
        t2.join();

    }
    
}
