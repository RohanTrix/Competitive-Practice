import sys 
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')
t = int(input())
for _ in range(t):
    x,y = map(int,input().split())
    x_even = x//2
    y_even = y//2
    if x%2==0:
        x_odd = x_even
    else:
        x_odd = x_even+1
    if y%2==0:
        y_odd = y_even   
    else:
        y_odd = y_even+1
    #print(x_odd, y_odd, x_odd, x_even)
    ans1 = y_even*x_even
    ans2 = y_odd*x_odd
    print(ans1+ans2)
