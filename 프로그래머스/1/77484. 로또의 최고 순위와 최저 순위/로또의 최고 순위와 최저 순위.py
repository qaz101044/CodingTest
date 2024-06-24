def solution(lottos, win_nums):
    answer = []
    zero_cnt = 0
    for i in lottos :
        if i == 0 :
            zero_cnt += 1
    
    win_cnt = 7
    for i in lottos :
        if i in win_nums :
            win_cnt -= 1
    
    if win_cnt >= 6 :
        win_cnt = 6
    
    max_answer = win_cnt - zero_cnt
    if max_answer == 0 :
        max_answer += 1
    
    answer.append(max_answer)
    answer.append(win_cnt)
    
    return answer