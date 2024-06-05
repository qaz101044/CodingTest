import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character,Integer> keyboard = new HashMap<>();
        
        for (int i=0; i < keymap.length; i++) {
            for (int j=0; j < keymap[i].length(); j++) {
                char temp = keymap[i].charAt(j);
                
                if (keyboard.containsKey(temp)) {
                    int idx = keyboard.get(temp);
                    keyboard.put(temp, Math.min(idx,j+1));
                }
                else {
                    keyboard.put(temp,j+1);
                }
            }
        }
        
        for (int i=0; i < targets.length; i++) {
            String target = targets[i];
            int cnt = 0;
            boolean flag = true;
            
            char[] T = target.toCharArray();
            for (char cur : T) {
                if (keyboard.containsKey(cur)) {
                    cnt += keyboard.get(cur);
                } else {
                    answer[i] = -1;
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                answer[i] = cnt;
            }
        }
        
        return answer;
    }
}