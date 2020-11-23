import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w') 
n, max_lect, k = map(int,input().split())
cnt=0
for i in range(n):
    l = list(map(int,input().split()))
    if sum(l[:-1])>=max_lect and l[-1]<=10:
        cnt+=1
print(cnt)