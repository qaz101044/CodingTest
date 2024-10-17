import sys
input = sys.stdin.readline
## x + y + = d - z

N = (int(input()))
arr = [int(input()) for _ in range(N)]
arr.sort()

arr2 = []

for i in range(N) :
    for j in range(i,N) :
        arr2.append(arr[i] + arr[j])

arr2.sort()
answer = 0

for i in range(N) :
    for j in range(i,N) : 
        a = arr[j] - arr[i]
        start = 0
        end = len(arr2) - 1
        
        while start <= end :
            mid = (start + end) // 2
            b = arr2[mid]
            
            if a > b :
                start = mid + 1
            elif a < b :
                end = mid - 1
            else :
                answer = max(answer,arr[j])
                break
print(answer)