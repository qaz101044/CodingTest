import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // dia, iron, stone
        int totalPicks = Arrays.stream(picks).sum();
        int[][] scoreBoard = new int[][] {{1,1,1},{5,1,1},{25,5,1}};
        
        List<int[]> list = new ArrayList<>();
        
        for (int i=0; i < minerals.length; i+=5) {
            // 곡괭이 전부 사용시
            if (totalPicks == 0) {
                break;
            }
            
            int dia = 0, iron = 0, stone = 0;
            for (int j=i; j < i+5; j++) {
                if (j == minerals.length) {
                    break;
                }
                String M = minerals[j];
                int val = M.equals("diamond") ? 0 : M.equals("iron") ? 1 : 2;
                
                dia += scoreBoard[0][val];
                iron += scoreBoard[1][val];
                stone += scoreBoard[2][val];
            }
            
            list.add(new int[] {dia,iron,stone});
            totalPicks--;
        }
        
        //for (int[] i : list) {
        //    System.out.println(Arrays.toString(i));
        //}
        
        Collections.sort(list, ((o1,o2) -> (o2[2] - o1[2])));
        
        for (int[] m : list) {
            int dia = m[0];
            int iron = m[1];
            int stone = m[2];
            
            if (picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            
            if (picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            
            if (picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }
        
        return answer;
    }
}