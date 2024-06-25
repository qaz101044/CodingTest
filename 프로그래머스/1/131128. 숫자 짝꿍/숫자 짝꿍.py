def solution(X, Y):
    answer = ''
    
    A = [0] * 10
    B = [0] * 10
    
    for i in X :
        value_X = int(i)
        A[value_X] += 1
        
    for i in Y :
        value_Y = int(i)
        B[value_Y] += 1
    
    for i in range(9,-1,-1) :
        value = str(i) * min(A[i],B[i])
        answer += value
    
    if len(answer) == 0 :
        return '-1'
    if answer[0] == '0' :
        return '0'
    return answer