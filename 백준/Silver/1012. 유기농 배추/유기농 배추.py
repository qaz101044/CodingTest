from collections import deque

def bfs(x,y) :
    global cnt
    ## 북,동,남,서
    dx = [-1,0,1,0]
    dy = [0,1,0,-1]
    
    visited[x][y] = 1
    q = deque()
    q.append((x,y))
    
    while q :
        sx,sy = q.popleft()
        for d in range(4) :
            nx = sx + dx[d]
            ny = sy + dy[d]
            
            if 0 <= nx < N and 0 <= ny < M :
                if visited[nx][ny] == 0 and board[nx][ny] == 1:
                    visited[nx][ny] = 1
                    q.append((nx,ny))
    
    cnt += 1
    

T = int(input())

for _ in range(T) :
    
    cnt = 0
    
    ## 배추밭 board 입력 받기 // N = 가로, M = 세로, K = 배추 개수
    N,M,K = map(int,input().split())
    
    board = [[0 for j in range(M)] for i in range(N)]
    
    for i in range(K) :
        bx,by = map(int,input().split())
        board[bx][by] = 1
    
    ##print(board)
    
    visited = [[0 for j in range(M)] for i in range(N)]
    
    for i in range(N) :
        for j in range(M) :
            if visited[i][j] == 0 and board[i][j] == 1 :
                bfs(i,j)
    ##for i in range(len(board)) :
    ##    print(board[i])
    print(cnt)
    