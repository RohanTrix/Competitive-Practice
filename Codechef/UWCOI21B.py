n,m = map(int,input().split())
a = sorted(list(map(int,input().split())))
b = sorted(list(map(int,input().split())))
i = 0
j = 0
swaps = 0
mini = min(a)
for j in range(m):
    if b[j] < mini:
        swaps+=n
print(swaps)