import sys
input = sys.stdin.readline

def solution(A, N, M) :
    left, right = 0,0
    answer = 2000000001
    
    while right < N :
        diff = A[right] - A[left]
        
        if diff < M :
            right += 1
        elif diff > M :
            answer = min(diff,answer)
            left += 1
        else :
            return M
    return answer

N, M = map(int,input().split())

A = []

for i in range(N) :
    A.append(int(input()))
    
A.sort()

answer = solution(A, N, M)
print(answer)
