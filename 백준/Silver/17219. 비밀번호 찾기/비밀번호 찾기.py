N,M = map(int,input().split())
hash = {}

for i in range(N) :
    a,b = input().strip().split()
    hash[a] = b

for i in range(M) :
    print(hash[input().strip()])