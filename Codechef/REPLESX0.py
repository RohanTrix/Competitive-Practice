import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')
def binary_search(arr, x): 
    low = 0
    high = len(arr) - 1
    mid = 0
  
    while low <= high: 
  
        mid = (high + low) // 2
  
        if arr[mid] < x: 
            low = mid + 1
  
        elif arr[mid] > x: 
            high = mid - 1
  
        else: 
            return mid 
    return -1
for _ in range(int(input())):
    n, X, p ,k = map(int,input().split())
    l = list(map(int,input().split()))
    p-=1
    k-=1
    op = 0
    if X not in l:
        op+=1
        l[k-1]= X
    l = sorted(l)
    val = binary_search(l,X)
    if (val<=k and k<p) or (p<k and k<=val):
        print(-1)
        continue
    print(abs(val-p))