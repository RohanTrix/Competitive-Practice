
import sys 
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+') 
for t in range(int(input())):
    n = int(input())
    s = input()
    if s[-1] in s[:n-1]:
        print("YES")
    else:
        print("NO")
