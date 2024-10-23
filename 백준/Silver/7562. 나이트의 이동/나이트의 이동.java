import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int x1, x2, y1, y2;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i=1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            visited = new int[N][N];

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt((st.nextToken()));

            bfs(x1,y1);

            sb.append(arr[x2][y2]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int x1, int y1) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1,y1});
        visited[x1][y1] = 1;

        while (!q.isEmpty()) {
            int[] s = q.poll();
            int sx = s[0];
            int sy = s[1];

            for (int d=0; d < 8; d++) {
                int nx = sx + dx[d];
                int ny = sy + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (visited[nx][ny] == 0) {
                        q.add(new int[]{nx,ny});
                        arr[nx][ny] = arr[sx][sy] + 1;
                        visited[nx][ny] = 1;
                    }
                }
            }
        } 
    }
}
