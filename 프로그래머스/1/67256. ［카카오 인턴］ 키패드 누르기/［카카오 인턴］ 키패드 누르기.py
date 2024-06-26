def calculate(cur,pad_x,pad_y) :
    return abs(cur[0]-pad_x) + abs(cur[1]-pad_y)

def solution(numbers, hand):
    ## 1,4,7 = 왼손
    ## 3,6,9 = 오른손
    ## 2,5,8,0 가까운 손, 같으면 손잡이 고려
    answer = ''
    L_cur = [3,0]
    R_cur = [3,2]
    
    X = [0,1,2,3]
    Y = [1,1,1,1]
    
    Left_arr = [1,4,7]
    Right_arr = [3,6,9]
    
    pad_x = -1
    pad_y = -1
    
    for i in numbers :
        
        if i in Left_arr :
            answer += 'L'
            temp_L = i // 3
            L_cur = [temp_L,0]
            
        elif i in Right_arr :
            answer += 'R'
            temp_R = i // 3
            R_cur = [temp_R-1,2]
        else :
            if i == 0 :
                pad_x = 3
                pad_y = 1
            else :
                pad_x = i // 3
                pad_y = 1
            
            dis_L = calculate(L_cur,pad_x,pad_y)
            dis_R = calculate(R_cur,pad_x,pad_y)
            
            if dis_L < dis_R :
                L_cur = [pad_x,pad_y]
                answer += 'L'
            elif dis_L > dis_R :
                R_cur = [pad_x,pad_y]
                answer += 'R'
            elif dis_L == dis_R :
                if hand == "right" :
                    R_cur = [pad_x,pad_y]
                    answer += 'R'
                else :
                    L_cur = [pad_x,pad_y]
                    answer += 'L'
            
    
    return answer