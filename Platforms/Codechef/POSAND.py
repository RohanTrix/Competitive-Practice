import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w') 
l = [2,3,1,5,4]
i = 6
while(i<10**5+1):
    if i and (not(i&(i-1))):
        l.append(i+1)
        l.append(i)
        i+=2
        continue
    l.append(i)
    i+=1
for _ in range(int(input())):
    n = int(input())
    if n==1:
        print(1)
        continue
    #Checking if n is a power of 2
    if n and (not(n&(n-1))):
        print(-1)
        continue
    else:
        print(*l[:n], sep = ' ')