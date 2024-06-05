from collections import deque

def solution(cards1, cards2, goal):
    answer = ''
    target = []
    
    cards_1 = deque(cards1)
    cards_2 = deque(cards2)
    
    cnt_1 = 0
    cnt_2 = 0
    
    cards_1.append('')
    cards_2.append('')
    
    for i in range(len(goal)) :
        if cards_1[cnt_1] == goal[i] :
            target.append(cards_1[cnt_1])
            cnt_1 += 1
        elif cards_2[cnt_2] == goal[i] :
            target.append(cards_2[cnt_2])
            cnt_2 += 1
        else :
            answer = "No"
            break
    
    if answer != "No" :
        if target == goal :
            answer = "Yes"
        else :
            answer ="No"
    
    return answer