N,M = map(int,input().split())

board = list(map(int,input().split()))

for i in range(M) :
    board.sort()
    t = board[0] + board[1]
    board[0] = t
    board[1] = t

answer = 0
for i in range(N) :
    answer += board[i]
print(answer)