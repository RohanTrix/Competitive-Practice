k,n,w = map(int , input().split())

w = w*(w+1)//2

if(k*w<=n):
    print(0)
else:
    print(k*w-n)
