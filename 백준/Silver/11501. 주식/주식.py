T = int(input())

for i in range(T) :
    N = int(input())
    price = list(map(int,input().split()))
    
    profit = 0
    
    maxPrice = 0
    for i in range(len(price)-1,-1,-1) :
        if price[i] > maxPrice :
            maxPrice = price[i]
        else :
            profit += maxPrice - price[i]
    
    print(profit)