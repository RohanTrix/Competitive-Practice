m,n,a = map(int, input().split())
ceil_m_a = (m+a-1)//a
ceil_n_a = (n+a-1)//a

print(ceil_m_a*ceil_n_a)