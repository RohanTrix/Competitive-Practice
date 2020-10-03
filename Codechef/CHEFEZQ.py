import sys 
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+') 

for _ in range(int(input())):
	n,k = map(int,input().split())
	l = list(map(int,input().split()))
	s = 0
	res = -1
	for i in range(n):
		s+=l[i]
		if (i+1)*k > s:
			res = i+1
			break
	if res==-1:
		sto = s - (n*k)
		print((sto//k)+1 +n)
	else:
		print(res)
