public class Maximum_Height_by_Stacking_Cuboids {
    
    Integer dp[] = new Integer[100];
    int cubes[][];
    int finAns = -1;
    public int getMax(int i)
    {
        if(dp[i]!=null) return dp[i];
        int maxi = 0;
        int l = cubes[i][0], b = cubes[i][1], h = cubes[i][2];
        
        for(int j =0; j<i; j++)
        {
            int val = getMax(j);
            if(b>=cubes[j][1] && h>=cubes[j][2])
                maxi = Math.max(maxi, val);
        }
        return dp[i] = maxi + h;
    }
    public int maxHeight(int[][] cuboids) {
        cubes = cuboids;
        
        for(int c[]: cubes) Arrays.sort(c);
        Arrays.sort(cubes, new Comparator<int[]>() {
            public int compare(int[] b, int[] a) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                if (a[1] != b[1])
                    return b[1] - a[1];
                return b[2] - a[2];
            }
        });

        
        // for(int c[]: cubes) 
        //     System.out.println(Arrays.toString(c));
        
        getMax(cubes.length-1);
        
        int maxi = 0;
        for(Integer a: dp)
            maxi = Math.max(maxi, a==null?0:a);
        return maxi;
        
    }
}
