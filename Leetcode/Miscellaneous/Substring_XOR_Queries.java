import java.util.HashMap;
import java.util.Map;

/**
 *      IDEA : Given relation: val ^ firsti == secondi    can be reformulated to val =  firsti ^ secondi =  X (say)
 *             which simplies to finding substring whose value is X.
 * 
 *             Now the tricky but easy to implement observation part is how to find the shortest substring that has decimal value X.
 * 
 *             To figure this out, look at the constraints, firsti and secondi <= 2^31 (10^9)
 *             So if we start forming a number at some ith position, we only need to check upto the next 31 bits.
 * 
 *             Now since we want the smallest...and leftmost substring for each query, we can pre-compute a HashMap 
 *             that maps val -> [i,j]...where i,j is the endpoints of the smallest and leftmost substring.
 *             Thsi will only take O( 32 * N)
 * 
 *             Then it becomes very easy to answer each query in O(1)
 *             
 * 
 * 
 */


public class Substring_XOR_Queries {
    public int[][] substringXorQueries(String str, int[][] queries) {
        char s[] = str.toCharArray();
        int n = s.length;
        Map<Integer, EndPoints> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int num = 0;
            for(int j = 0; j<31 && i+j<n; j++){
                num<<=1;
                num|=(s[i+j] - '0');
                map.putIfAbsent(num, new EndPoints(i,i+j));
                if(map.containsKey(num) && map.get(num).length() > j+1 ){
                    map.put(num, new EndPoints(i,i+j));
                }
            }
        }
        int ans[][] = new int[queries.length][2];
        for(int q = 0; q<queries.length; q++){
            int a = queries[q][0], b = queries[q][1];
            EndPoints p = map.getOrDefault(a^b, new EndPoints(-1,-1));
            ans[q][0] = p.i1; ans[q][1] = p.i2;
        }
        return ans;
    }
    public record EndPoints(Integer i1, Integer i2){
        public int length(){
            return i2-i1+1;
        }
    }
}
