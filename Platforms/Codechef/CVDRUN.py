for _ in range(int(input())):
	n,k,x,y = map(int,input().split())
	s = {x}
	f= True
	while((x+k)%n!=y):
		if (x+k)%n in s:
			f= False
			break
		x = (x+k)%n
		s.add(x)
	if f:
		print('YES')
	else:
		print('NO')
