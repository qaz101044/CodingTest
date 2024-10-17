import sys
input = sys.stdin.readline

## M = 조카의 수 , N = 과자의 수
M, N = map(int,input().split())
A = list(map(int,input().split()))

start = 1
end = max(A)
answer = 0
while start <= end :
    mid = (start + end) // 2
    cnt = 0
    for i in A :
        ## 자르려는 단위보다 과자가 작으면 못 자름
        if i < mid :
            continue
        else :
            cnt += i // mid
    
    if cnt >= M :
        start = mid + 1
        answer = mid
    else :
        end = mid - 1

print(answer)