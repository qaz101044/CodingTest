def solution(k, m, score):
    answer = 0
    
    L = len(score) // m
    score.sort(reverse=True)
    for i in range(L) :
        temp = score[i*m : (i+1)*m]
        answer += min(temp) * m
        #print(temp)
    
    return answer