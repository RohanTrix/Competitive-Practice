package Hackerearth;

import java.util.*;
public class Input_expectations {
    public static void main(String args[] ) throws Exception {
        Scanner sc=  new Scanner(System.in);
        int t = sc.nextInt();
        int cnt=0;
        for(int i = 0; i < t; i++){
        
            int n;
            if(sc.hasNext()){
                n = sc.nextInt();
                while(n>0 && sc.hasNext())
                {
                    sc.nextInt();
                    n-=1;
                }
                cnt+=n;
            }
            else
            {
                cnt+=1;
            }     
        }
        sc.close();
        System.out.println(cnt);
    }
}
