def solution(video_len, pos, op_start, op_end, commands):
    answer = 0
    ## 초로 변환
    videoBoard = []
    
    # video_len
    video_len_arr = video_len.split(":")
    video_len_int_arr = list(map(int,video_len_arr))
    videoBoard.append(60*video_len_int_arr[0] + video_len_int_arr[1])
    
    # pos
    pos_len_arr = pos.split(":")
    pos_len_int_arr = list(map(int,pos_len_arr))
    videoBoard.append(60*pos_len_int_arr[0] + pos_len_int_arr[1])
    
    # op_start
    op_start_len_arr = op_start.split(":")
    op_start_len_int_arr = list(map(int,op_start_len_arr))
    videoBoard.append(60*op_start_len_int_arr[0] + op_start_len_int_arr[1])
    
    # op_end
    op_end_len_arr = op_end.split(":")
    op_end_len_int_arr = list(map(int,op_end_len_arr))
    videoBoard.append(60*op_end_len_int_arr[0] + op_end_len_int_arr[1])
    
    
    # command 실행
    for command in commands : 
        ## pos가 오프닝 구간인 경우 1
        if videoBoard[2] <= videoBoard[1] < videoBoard[3] :
            videoBoard[1] = videoBoard[3]
            
        if command == 'next' :
            videoBoard[1] += 10
            if videoBoard[1] > videoBoard[0] :
                videoBoard[1] = videoBoard[0]
            
        elif command == 'prev' :
            videoBoard[1] -= 10
            if videoBoard[1] < 0 :
                videoBoard[1] = 0
        
        ## pos가 오프닝 구간인 경우 2
        if videoBoard[2] <= videoBoard[1] < videoBoard[3] :
            videoBoard[1] = videoBoard[3]
        
    answer = []
    q = videoBoard[1] // 60
    if q < 10 :
        q = str("0") + str(q)
    res = videoBoard[1] % 60
    if res < 10 :
        res = str("0") + str(res)
    
    answer.append(q)
    answer.append(res)
    
    return ":".join(map(str,answer))