def solution(strings, n):
    answer = []
    temp = []
    for s in strings :
        temp.append([s,s[n]])
    
    temp.sort(key=lambda x:(x[1],x[0]))
    for x,y in temp :
        answer.append(x)
    return answer