def solution(s, skip, index):
    answer = ''
    alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    
    arr = list(s)
    arr_skip = list(skip)
    ##print(arr)
    
    for i in arr :
        temp = -1
        cnt = index
        for j in range(len(alpha)) :
            if i == alpha[j] :
                temp = j
                break
        
        while cnt > 0 :
            temp += 1
            if not alpha[temp % 26] in arr_skip :
                cnt -= 1
        
        answer += alpha[temp % 26]

    return answer