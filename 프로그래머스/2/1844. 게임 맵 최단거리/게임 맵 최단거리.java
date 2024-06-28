import java.util.*;

class Solution {
    
    // 북,동,남,서
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        
        if (answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while (!q.isEmpty()) {
            int[] current = q.remove();
            int sx = current[0];
            int sy = current[1];
            
            for(int i=0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[sx][sy] + 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
    
}