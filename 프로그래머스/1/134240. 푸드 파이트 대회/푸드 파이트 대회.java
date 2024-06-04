import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        String temp = "";
        
        for (int i=1; i < food.length; i++) {
            food[i] = food[i] / 2;
        }
        
        for (int i=1; i < food.length; i++) {
            for (int j=0; j < food[i]; j++) {
                temp += Integer.toString(i);
            }
        }
        
        //System.out.println(temp);
        
        StringBuilder sb = new StringBuilder(temp);
        sb.reverse();
        String reversed = sb.toString();
        
        answer = temp + "0" + reversed;
        return answer;
    }
}