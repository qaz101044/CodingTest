N = int(input())
C = int(input())

graph = [[] for j in range(N+1)]
visited = [0] * (N+1)

for i in range(C) :
    a,b = map(int,input().split())
    
    graph[a] += [b]
    graph[b] += [a]

##print(graph)
def dfs(k) :
    visited[k] = 1
    for nx in graph[k] :
        if visited[nx] == 0 :
            dfs(nx)

dfs(1)
##print(visited)
print(sum(visited) - 1)