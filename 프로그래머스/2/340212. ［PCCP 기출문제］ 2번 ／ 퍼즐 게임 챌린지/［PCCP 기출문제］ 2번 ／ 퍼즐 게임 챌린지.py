def solution(diffs, times, limit):
    # binary search
    ## 현재 퍼즐 난이도 = diff
    ## 현재 퍼즐의 소요 시간 = time_cur
    ## 이전 퍼즐의 소요 시간 = time_prev
    ## 당신의 숙련도 = level
    
    left_level, right_level = 100001, 0
    answer = 100002
    
    while right_level <= left_level :
        cur_level = (right_level + left_level) // 2
        if answer == cur_level :
            break
            
        myTime = 0
        time_prev = 0
        
        for diff, time_cur in zip(diffs, times) :
            if diff <= cur_level :
                myTime += time_cur
            else : 
                n = diff - cur_level
                total_time = time_cur + time_prev
                myTime += n * total_time + time_cur
            time_prev = time_cur
            
        if myTime <= limit :
            answer = min(answer,cur_level)
            
        if myTime > limit :
            right_level = cur_level
        else :
            left_level = cur_level + 1
    return answer