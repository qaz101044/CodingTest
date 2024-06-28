class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int sum_square = 0;
        int multiply_sum = 1;
        
        for (int i=0; i < num_list.length; i++) {
            sum_square += num_list[i];
            multiply_sum *= num_list[i];
        }
        
        if (multiply_sum < Math.pow(sum_square,2)) {
            answer = 1;
        }
        else {
            answer = 0;
        }
        return answer;
    }
}