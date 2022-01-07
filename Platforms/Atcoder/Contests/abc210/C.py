n,k = map(int,input().split())
can = list(map(int,input().split()))
d = {}
for i in can[:k]:
    if i not in d:
        d[i] = 1
    else:
        d[i]+=1

maxlen = len(d)
for i in range(1, n-k+1):
    d[can[i-1]]-=1
    if d[can[i-1]]==0:
        del d[can[i-1]]
    if can[i+k-1] not in d:
        d[can[i+k-1]] = 1
    else:
        d[can[i+k-1]]+=1
    maxlen = max(maxlen, len(d))
print(maxlen)