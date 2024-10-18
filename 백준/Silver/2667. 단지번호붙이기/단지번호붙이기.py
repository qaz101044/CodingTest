from collections import deque

## 북 / 동 / 남 / 서
dx = [-1,0,1,0]
dy = [0,1,0,-1]

N = int(input())

board = []
for i in range(N) :
    board.append(list(map(int,input())))

visited = [[0 for j in range(N)] for i in range(N)]
answer = []
num = 1

def bfs(x,y) :
    global num
    q =deque()
    q.append([x,y])
    visited[x][y] = num
    cnt = 1
    
    
    while q :
        sx,sy = q.popleft()
        
        for d in range(4) :
            nx = sx + dx[d]
            ny = sy + dy[d]
            
            if (0 <= nx < N ) and (0 <= ny < N) :
                if visited[nx][ny] == 0 and board[nx][ny] == 1 :
                    visited[nx][ny] = cnt
                    q.append([nx,ny])
                    cnt += 1
    
    num += 1
    return cnt

for i in range(N) :
    for j in range(N) :
        if visited[i][j] == 0 and board[i][j] == 1 :
            answer.append(bfs(i,j))

print(len(answer))
##print(answer)
answer.sort()
for i in answer :
    print(i)
