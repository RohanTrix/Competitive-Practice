```java
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        int cnt =0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = k - arr[i];
            if (map.containsKey(complement)) {
               cnt+= map.get(complement);
            }
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        return cnt;
    }
}
```