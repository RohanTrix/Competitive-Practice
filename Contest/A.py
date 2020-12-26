import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')
for t in range(int(input())):
    s = input()
    d = {}
    for i in s:
        if i not in d:
            d[i] = 1
        else:
            d[i]+=1
    one = 0
    two = 0
    for i in d.values():
        if i==1:
            one+=1
        else:
            two+=i//2
            one+=i%2
    coins = 0
    if one<=two:
        coins+=one
        two-=one
        coins+=(2*two)//3
    else:
        coins+=two
    print(coins)





