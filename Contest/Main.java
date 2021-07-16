import java.io.*; import java.util.*; import java.util.stream.*;
 
@SuppressWarnings("all") class Pair { long x, y; public Pair(long xi,long yi) { x = xi; y = yi; }
 
} class MyComp implements Comparator { public int compare(Object o1, Object o2) { Pair p1 = (Pair) o1; 
	Pair p2 = (Pair) o2; return Long.compare(p2.y, p1.y); } } 
public class Solution 
{ public static void main(String[] args)
	 { 
		 Scanner sc = new Scanner(System.in);
		 int n, m,k ; n = sc.nextInt();
		  m = sc.nextInt();; k = sc.nextInt();

		   Long[] fact = new Long[n]; 
		   for(int i =0; i<n; i++) fact[i] = sc.nextLong();
 
	Pair mar[] = new Pair[m];
	for(int i  =0; i<m; i++) mar[i] = new Pair(sc.nextInt(), sc.nextInt());
	
	Long rent[] = new Long[k];
	for(int i = 0; i<k; i++) rent[i] = sc.nextLong();

	Arrays.sort(rent, Collections.reverseOrder());
	Arrays.sort(fact, Collections.reverseOrder());
	Arrays.sort(mar, new MyComp());
	
	Long prefixSum[] = new Long[k];
	prefixSum[0] = rent[0];
		for (int i = 1; i < k; ++i)
			prefixSum[i] = prefixSum[i - 1] + rent[i];
	
	long factNum = 0;
	long bestAns =0;
	for(int i =0; i<k;i++)bestAns+=rent[i];
	for(int i = 0; i<n; ++i)
	{
		factNum+=fact[i].longValue();
		long factNumCopy = factNum;
		//Finding profit by selling
		long p1 = 0L;
		for(int curr = 0 ; curr<m; curr++)
		{
			p1 += Math.min(mar[curr].x, factNumCopy)*mar[curr].y;
			factNumCopy-= Math.min(mar[curr].x, factNumCopy);
			if(factNumCopy==0) break;
		}
		//Finding profit by rent   100 80 60 
		int rentNum = n-i-2;
		long p2 = (rentNum!=-1)?prefixSum[rentNum].longValue():0;
		bestAns = Math.max(p1+p2, bestAns);
		//System.out.println(p1+" "+p2);
 
   }
   System.out.println(bestAns);
 
 
 
 
}
}