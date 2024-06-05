import java.util.*;


class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int idx_1 = 0;
        int idx_2 = 0;
        
        for (int i=0; i < goal.length; i++) {
            if (idx_1 < cards1.length && goal[i].equals(cards1[idx_1])) {
                idx_1 += 1;
            }
            else if (idx_2 < cards2.length && goal[i].equals(cards2[idx_2])) {
                idx_2 += 1;
            }
            else {
                return "No";
            }
        }
        
        return answer;
    }
}