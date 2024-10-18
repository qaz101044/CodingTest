N = int(input())
box_arr = list(map(int,input().split()))
dp = [1 for _ in range(len(box_arr))]

##print(dp)

for i in range(1,N) :
    for j in range(i) :
        if box_arr[j] < box_arr[i] :
            dp[i] = max(dp[i],dp[j]+1)

print(max(dp))