import java.util.*;

class Solution {
    public int solution(String s) {
        String[] voca = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        //System.out.println(Arrays.toString(voca));
        
        for (int i=0; i < 10; i++) {
            if (s.contains(voca[i])) {
                s = s.replace(voca[i], Integer.toString(i));
            }
        }
        
        return Integer.parseInt(s);
    }
}