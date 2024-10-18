import sys
from collections import defaultdict

def solution(N,K,arr) :
    answer = 0
    left = 0
    right = 0
    
    numberCount = defaultdict(int)
    
    while right < N :
        if numberCount[arr[right]] >= K :
            numberCount[arr[left]] -= 1
            left += 1
        else :
            numberCount[arr[right]] += 1
            right += 1
            answer = max(answer,right - left)
    
    return answer
    
    
input = sys.stdin.readline

N,K = map(int,input().split())
arr = list(map(int,input().split()))

print(solution(N,K,arr))
