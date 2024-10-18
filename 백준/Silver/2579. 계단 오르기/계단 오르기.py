import sys
input = sys.stdin.readline

N = int(input())

steps = [0] * 301
for i in range(1,N+1) :
    steps[i] = int(input())

dp = [0] * 301
dp[1] = steps[1]
dp[2] = steps[1] + steps[2]
dp[3] = max(steps[1] + steps[3], steps[2] + steps[3])

for i in range(4,N+1) :
    dp[i] = max(dp[i-3] + steps[i-1] + steps[i] , dp[i-2] + steps[i])

print(dp[N])
