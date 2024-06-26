def solution(a, b):
    answer = ''
    days = ['THU','FRI','SAT','SUN','MON','TUE','WED']
    month = [31,29,31,30,31,30,31,31,30,31,30,31]
    
    total_day = sum(month[0:a-1])
    total_day += b
    
    answer = days[total_day % 7]
    return answer