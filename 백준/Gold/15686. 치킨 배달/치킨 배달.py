N, M = map(int,input().split())
min_ans = 987654321

home = []
chicken = []

## 0 = 빈 칸, 1 = 집, 2 = 치킨집
board = [list(map(int,input().split())) for _ in range(N)]

for i in range(N) :
    for j in range(N) :
        if board[i][j] == 1 :
            home.append((i,j))
        elif board[i][j] == 2 :
            chicken.append((i,j))
            
visited = [False] * len(chicken)

def dfs(idx,cnt) :
    global min_ans
    
    if cnt == M :
        ans = 0
        
        for i in home :
            distance = 987654321
            for j in range(len(visited)) :
                if visited[j] :
                    check_num = abs(i[0] - chicken[j][0]) + abs(i[1] - chicken[j][1])
                    distance = min(distance,check_num)
            ans += distance
        min_ans = min(ans,min_ans)
        
        return
    
    for i in range(idx,len(chicken)) :
        if not visited[i] :
            visited[i] = True
            dfs(i+1,cnt+1)
            visited[i] = False

dfs(0,0)
print(min_ans)