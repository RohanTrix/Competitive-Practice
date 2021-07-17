n,a,x,y = map(int,input().split())
a = min(n,a)
n-=a
print(a*x + n*y)
