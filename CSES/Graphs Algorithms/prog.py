# import sys
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w')
from collections import deque
n,m = map(int,input().split())
mat = []
si = sj = 0
endi = endj = 0
for i in range(n):
    l = list(input())
    for j in range(m):
        if l[j]=='A':
            si,sj = i,j
        if l[j]=='B':
            endi, endj = i,j
    mat.append(l)

f = False
q = deque()
dir = [["#" for i in range(m)] for i in range(n)]
q.append([si,sj])
while(len(q)!=0):
    tmp = q.popleft()
    if (tmp[0] == endi and tmp[1] == endj):
        f = True
        break
    x = tmp[0]
    y = tmp[1]
    mat[x][y] = '#'
    nx = ny = 0
    
    # Left
    nx = x
    ny = y-1
    if (not(nx < 0 or nx >= n or ny < 0 or ny >= m or mat[nx][ny] == '#')):
        q.append([nx,ny])
        dir[nx][ny] = 'L'
    # Right
    nx = x
    ny = y+1
    if (not(nx < 0 or nx >= n or ny < 0 or ny >= m or mat[nx][ny] == '#')):
        q.append([nx,ny])
        dir[nx][ny] = 'R'
    # Up
    nx = x-1
    ny = y
    if (not(nx < 0 or nx >= n or ny < 0 or ny >= m or mat[nx][ny] == '#')):
        q.append([nx,ny])
        dir[nx][ny] = 'U'
    # Down
    nx = x+1
    ny = y
    if (not(nx < 0 or nx >= n or ny < 0 or ny >= m or mat[nx][ny] == '#')):
        q.append([nx,ny])
        dir[nx][ny] = 'D'

if not f:
    print("NO")
else:
    s = []
    nx,ny = endi, endj
    while nx!=si or ny!=sj:
        s.append(dir[nx][ny])
        c = dir[nx][ny]

        if c=='L':
            ny+=1
        elif c=='R':
            ny-=1
        elif c=='U':
            nx+=1
        else:
            nx-=1
    print("YES")
    print(len(s))
    print(*s[::-1], sep='')
