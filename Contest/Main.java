import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            
            int x; 
            x = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.compressArray(n, arr, x);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int compressArray(int n, int[] arr, int x) {
        // code here
        int saved = 0, left = 0;
        int pref[] = new int[n+1];
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        for(int right = 1; right<n; right++)
        {
            int l = 0, r = right-1;
            int ans = -1;
            while(l<=r)
            {
                int mid = (l+r)/2;
                if((arr[right]>arr[mid]) && (arr[right]<=(arr[mid]+x)))
                {
                    ans = mid;
                    r = mid - 1;
                }
                else
                    l = mid + 1;
            }
            if(ans == -1) continue;
            pref[ans]++;
            pref[right]--;
        }
        
        for(int i = 1; i<n; i++)
        {
            pref[i]+=pref[i-1];
        }
        for(int i = 0; i<n; i++)
        {
            if(pref[i] == 0) saved++;
        }
        return saved;
    }
}
        
