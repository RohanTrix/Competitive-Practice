import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w') 
for _ in range(int(input())):
    n = int(input())
    if n==1:
        print(0)
    elif(n==2):
        print(1)
    elif n==3:
        print(2)
    elif n%2==0:
        print(2)
    
    else:
        print(3)