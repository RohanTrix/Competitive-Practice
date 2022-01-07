package Hackerearth;

import java.util.*;
public class Minimum_and_maximum_differences {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min[] = new int[n+1];
        int max[] = new int[n+1];
        int fix[] = {0,3,1,2};
        if(n==1){
            System.out.println(-1);
            System.out.println(-1);
        }
        else if (n==2)
        {
            System.out.println(2);
            System.out.println("2 1");
            System.out.println(2);
            System.out.println("2 1");
        }
        else if( n==3)
        {
            System.out.println("4\n3 1 2\n4\n2 3 1");
        }
        else if(n%2==0){
            for( int i=1; i<n;i+=2)
            {
                min[i] = i+1;
                min[i+1] = i;
            }
            System.out.println(n);
            for(int i = 1;i<=n;i++)
                System.out.print(min[i]+ " ");
            System.out.println();
            int s = 0;
            for(int i=1;i<=n/2;i++)
            {
                s+=(n-i+1)-i;
            }
            System.out.println(2*s);
            for(int i=n; i>0;i--)
            System.out.print(i+ " ");
        }
        else{
            min[1] = fix[1];min[2] = fix[2];min[3] = fix[3];
            for(int i=1;i<=n-3;i+=2)
            {
                min[i] = i+1;
                min[i+1] = i;
            }
            int temp = n;
            min[n] = n-1;
            min[n-1] = n-2;
            min[n-2] = temp;
            System.out.println(n+1);
            for(int i = 1;i<=n;i++)
                System.out.print(min[i]+ " ");
            System.out.println();
            int s=0;
            for(int i = 1;i<=n;i++)
            max[n-i+1] = i;
            temp = max[(n+1)/2];
            max[(n+1)/2] = max[((n+1)/2)-1];
            max[((n+1)/2)-1] = temp;
            for(int i=1;i<=n;i++)
            {
                s+=Math.abs(max[i]-i);
            }
            System.out.println(s);
            for(int i=1;i<=n;i++)
            System.out.print(max[i]+ " ");

            

            //System.out.println(Arrays.toString(min));
            
            }

    }
}
