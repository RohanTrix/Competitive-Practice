n = int(input())
s = list(map(int,input().split()))
t = list(map(int,input().split()))
 
 
 
ans = [t[i] for i in range(n)]
 
for i in range(2*n):
    ans[(i+1)%n] = min(ans[(i+1)%n], ans[i%n] + s[i%n])
#print(club)
 
print(*ans, sep = '\n')