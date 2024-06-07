from collections import deque

def solution(k, score):
    answer = []
    
    q = deque()
    
    for i in score :
        
        if len(q) < k :
            q.append(i)
            temp = list(q)
            temp.sort(reverse=True)
            q = deque(temp)
            answer.append(q[-1])
        
        else :
            #print(q)
            if q[-1] < i :
                q.pop()
                q.append(i)
                t = list(q)
                t.sort(reverse=True)
                q = deque(t)
                answer.append(q[-1])
            else :
                answer.append(q[-1])
        
        
    return answer