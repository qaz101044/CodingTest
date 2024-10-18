from collections import deque

N,M = map(int,input().split())
board = [list(map(int,input().strip())) for j in range(N)]

visited = [[[0 for k in range(M)] for j in range(N)] for i in range(2)]

## 북 / 동 / 남 / 서
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(z,x,y) :
    q = deque()
    q.append([z,x,y])
    visited[z][x][y] = 1
    
    while q :
        sz,sx,sy = q.popleft()
        
        if sx == N-1 and sy == M-1 :
            return visited[sz][sx][sy]
        
        for d in range(4) :
            nx = sx + dx[d]
            ny = sy + dy[d]
            
            if (0 <= nx < N) and (0 <= ny < M) :
                if (board[nx][ny] == 1 ) and sz == 0 and visited[sz][nx][ny] == 0:
                    visited[sz+1][nx][ny] = visited[sz][sx][sy] + 1
                    q.append([1,nx,ny])
                elif (board[nx][ny] == 0) and (visited[sz][nx][ny] == 0) :
                    visited[sz][nx][ny] = visited[sz][sx][sy] + 1
                    q.append([sz,nx,ny])
    
    return -1

print(bfs(0,0,0))
##for i in range(len(visited)) :
##    for j in range(len(visited[0])) :
##        print(visited[i][j])
    