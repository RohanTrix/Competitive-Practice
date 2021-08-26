import math
# import sys
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w+')

# Refer : https://youtu.be/AdSFKmC-mnY

for t in range(int(input())):
    n  = int(input())
    arr = list(map(int,input().split()))
    arr.sort()
    mini = float("inf")
    pos = 0
    for i in range(n-1):
        if abs(arr[i]-arr[i+1])<mini:
            mini = abs(arr[i]-arr[i+1])
            pos = i
    l = [arr[pos]] + arr[pos+2:] + arr[:pos] + [arr[pos+1]]
    print(*l)