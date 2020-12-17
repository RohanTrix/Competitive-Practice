class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n=A.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int k=0;
        for(int i=0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
            
        }
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            for( int j = 0;j<n;j++)
            {
                int sum = C[i] +D[j];
                cnt+=map.getOrDefault(-sum,0);
            }
        }
        //System.out.println(Arrays.toString(s1));
        //System.out.println(Arrays.toString(s2));
        return cnt;
    }
}