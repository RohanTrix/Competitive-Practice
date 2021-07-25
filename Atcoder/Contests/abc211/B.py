s = set(['H', '2B', '3B','HR'])
s1,s2,s3,s4 = [input() for i in range(4)]

s.discard(s1)
s.discard(s2)
s.discard(s3)
s.discard(s4)
if len(s)==0:
    print('Yes')
else:
    print('No')