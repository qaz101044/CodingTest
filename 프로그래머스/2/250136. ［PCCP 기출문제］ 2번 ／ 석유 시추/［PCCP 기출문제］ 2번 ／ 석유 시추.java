import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static int[] oil;
    
    // 북,동,남,서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        
        oil = new int[M];
        
        int[][] visited = new int[N][M];
        
        for (int i=0; i < N; i++) {
            for (int j=0; j < M; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    bfs(land,visited,i,j);
                }
            }
        }
        
        answer = Arrays.stream(oil).max().getAsInt();
        System.out.println(answer);
        
        return answer;
    }
    
    public void bfs(int[][] land, int[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        
        // 최초 좌표 삽입
        q.add(new int[] {x,y});
        visited[x][y] = 1;
        
        int cnt = 1;
        Set<Integer> tempSet = new HashSet<>();
        
        while(!q.isEmpty()) {
            int[] s = q.poll();
            tempSet.add(s[1]);
            
            for (int d=0; d < 4; d++) {
                int nx = s[0] + dx[d];
                int ny = s[1] + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visited[nx][ny] == 0 && land[nx][ny] == 1) {
                        q.add(new int[] {nx,ny});
                        visited[nx][ny] = 1;
                        cnt += 1;
                    }
                }
            }
        }
        
        for (int index : tempSet) {
            oil[index] += cnt;
        }
    }
}