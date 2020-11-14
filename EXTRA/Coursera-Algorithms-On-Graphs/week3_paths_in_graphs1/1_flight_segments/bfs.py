import sys
import queue

def distance(n, adj, s, t):
    visited = [(False) for _ in range(n)]
    dist = [(-1) for _ in range(n)]
    q = queue.Queue()
    q.put(s)
    visited[s] = True
    dist[s] = 0
    if s == t:
        return 0
    while not q.empty():
        x = q.get()
        for i in adj[x]:
            if i == t:
                return dist[x]+1
            elif not visited[i]:
                q.put(i)
                dist[i] = dist[x]+1
                visited[i] = True
    return -1

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n, m = data[0:2]
    data = data[2:]
    edges = list(zip(data[0:(2 * m):2], data[1:(2 * m):2]))
    adj = [[] for _ in range(n)]
    for (a, b) in edges:
        adj[a - 1].append(b - 1)
        adj[b - 1].append(a - 1)
    s, t = data[2 * m] - 1, data[2 * m + 1] - 1
    print(distance(n, adj, s, t))
