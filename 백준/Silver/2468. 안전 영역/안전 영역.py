from collections import deque

import sys
input = sys.stdin.readline

## 북 / 동 / 남 / 서
dx = [-1,0,1,0]
dy = [0,1,0,-1]

N = int(input())

board = []
for i in range(N) :
    board.append(list(map(int,input().split())))

min_value = 101
max_value = -1
for i in range(N) :
    for j in range(N) :
        if board[i][j] > max_value :
            max_value = board[i][j]
        elif board[i][j] < min_value :
            min_value = board[i][j]

answer = 1

def bfs(x,y) :
    q = deque()
    q.append([x,y])
    visited[x][y] = 1
    
    while q :
        sx,sy = q.popleft()
        
        for d in range(4) :
            nx = sx + dx[d]
            ny = sy + dy[d]
            
            if (0 <= nx < N and 0 <= ny < N) :
                if (board[nx][ny] > level and visited[nx][ny] == 0) :
                    q.append([nx,ny])
                    visited[nx][ny] = 1
    

for i in range(min_value,max_value+1) :
    level = i
    visited = [[0 for j in range(N)] for i in range(N)]
    cnt = 0
    for j in range(N) :
        for k in range(N) :
            if board[j][k] > level and visited[j][k] == 0 :
                bfs(j,k)
                cnt += 1
    answer = max(cnt,answer)

print(answer)