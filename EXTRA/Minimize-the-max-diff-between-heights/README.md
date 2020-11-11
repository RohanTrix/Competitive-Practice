# Minimize-the-max-diff-between-heights

### Algorithm :
1. Sort array in increasing order
2. Initialize maximum and minimum elements.
3. max = arr[n-1], mine = arr[0]
4. If k is more than difference between maximum and minimum, add/subtract k to all elements as k cannot decrease the difference. Example {6, 4}, k = 10.
5. In sorted array, update first and last elements.
6. arr[0] += k; // arr[0] is minimum and k is +ve
7. arr[n-1] -= k; // arr[n-1] is maximum and k is -ve
8. Initialize max and min of modified array (only two elements have been finalized), new_max = max(arr[0], arr[n-1]), new_min = min(arr[0], arr[n-1])
9. Finalize middle n-2 elements. Do following for every element arr[j] where j lies from 1 to n-2.
10. If current element is less than min of modified array, add k.
    Else If current element is more than max of modified array, subtract k.
11. arr[j] is between new_min and new_max.
12. If arr[j] is closer to new_max, subtract k
13. Else add k to arr[j].
14. Update new_max and new_min if required
15. new_max = max(arr[j], new_max), new_min = min(arr[j], new_min)
Returns difference between new_max and new_min
return (new_max – new_min);