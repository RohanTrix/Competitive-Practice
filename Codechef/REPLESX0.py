import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')
t = int(input())
def binary_search(arr, x): 
    low = 0
    high = len(arr) - 1
    mid = 0
  
    while low <= high: 
  
        mid = (high + low) // 2
  
        # Check if x is present at mid 
        if arr[mid] < x: 
            low = mid + 1
  
        # If x is greater, ignore left half 
        elif arr[mid] > x: 
            high = mid - 1
  
        # If x is smaller, ignore right half 
        else: 
            return mid 
  
    # If we reach here, then the element was not present 
    return -1

while(t):
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
    if p<=val:
        if p<k:
            print(-1)
            continue
        else:
            print(val-p)
    else:
        if p>k:
            print(-1)
        else:
            print(p-val)
    t-=1