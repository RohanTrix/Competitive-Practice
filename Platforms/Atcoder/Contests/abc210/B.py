n = int(input())
s = input()
for i in range(len(s)):
    if s[i]=='1':
        print('Takahashi') if i%2==0 else print("Aoki")
        break