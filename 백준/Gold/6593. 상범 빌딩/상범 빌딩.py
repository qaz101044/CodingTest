from collections import deque

while True :

    L,R,C = map(int,input().split())
    if L == R == C == 0 :
        break

    board = []
    ## 3차원 board 생성
    for i in range(L) :
        board_layer = []
        
        for j in range(R+1) :
            line = input().strip()
        
            if line == ''  :
                board.append(board_layer)
            
            else :
                board_layer.append(list(line))
            
    ## 북 / 동 / 남 / 서 / 위 / 아래
    dx = [-1,0,1,0,0,0]
    dy = [0,1,0,-1,0,0]
    dz = [0,0,0,0,-1,1]

    visited = [[[0 for k in range(C)] for j in range(R)] for i in range(L)]

    ## 시작 지점 탐색
    sz = -1
    sx = -1
    sy = -1
    for i in range(L) :
        for j in range(R) :
            for k in range(C) :
                if board[i][j][k] == 'S' :
                    sz = i
                    sx = j
                    sy = k
    ez = -1
    ex = -1
    ey = -1
    for i in range(L) :
        for j in range(R) :
            for k in range(C) :
                if board[i][j][k] == 'E' :
                    ez = i
                    ex = j
                    ey = k

    def bfs(z,x,y) :
        q = deque()
        q.append([z,x,y])
        visited[z][x][y] = 1
        
        while q :
            tz,tx,ty = q.popleft()
            
            for d in range(6) :
                nz = tz + dz[d]
                ny = ty + dy[d]
                nx = tx + dx[d]
                
                if (0 <= nx < R) and (0 <= ny < C) and (0 <= nz < L) :
                    if(visited[nz][nx][ny] == 0 and board[nz][nx][ny] != '#') :
                        visited[nz][nx][ny] = visited[tz][tx][ty] + 1
                        q.append([nz,nx,ny])
        
        return visited[ez][ex][ey]
    answer = bfs(sz,sx,sy)
    ##for i in range(len(visited)) :
    ##    for j in range(len(visited[0])) :
    ##        print(visited[i][j])
    if answer == 0 :
        print("Trapped!")
    else :
        print(f"Escaped in {answer-1} minute(s).")