import java.io.*;
import java.util.*;

public class Main {
    
    static int m,n,h; // 행, 열, 높이
    static int result;
    static boolean chk = true;

    static int[][][] board;
    static int[][][] visited;
    static Queue<int[]> q;

    // 위 아래 북 동 남 서
    static int[] dz = {-1,1,0,0,0,0};
    static int[] dx = {0,0,-1,0,1,0};
    static int[] dy = {0,0,0,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // m, n, h 입력
        // m = 상자의 가로 칸수(== 열)
        // n = 상자의 세로 칸수(== 행)
        // h = 상자의 높이 칸수(== 높이)

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];
        visited = new int[h][n][m];
        q = new LinkedList<>();

        for (int i=0; i < h; i++) {
            for (int j=0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());

                    // 익은 토마토가 있는 칸 : 1
                    if (board[i][j][k] == 1) {
                        q.add(new int[]{i,j,k});
                        visited[i][j][k] = 1;
                    }

                    // 익지 않은 토마토가 있는 칸 : 0
                    else if (chk && board[i][j][k] == 0) {
                        chk = false;
                    }

                    // 토마토가 없는 칸 : -1
                    else if (board[i][j][k] == -1) {
                        visited[i][j][k] = -1;
                    }
                }
            }
        }

        if (chk) {
            System.out.println(0);
        }

        else {
            bfs();
            System.out.println(check());
            //System.out.println(Arrays.deepToString(visited));
            //System.out.println(q);
        }
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int z = p[0];
            int x = p[1];
            int y = p[2];

            for (int d=0; d < 6; d++) {
                int nz = z + dz[d];
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= h || nx >= n || ny >= m) {
                    continue;
                }

                if (board[nz][nx][ny] == 0 && visited[nz][nx][ny] == 0) {
                    q.add(new int[]{nz,nx,ny});
                    visited[nz][nx][ny] = visited[z][x][y] + 1;
                }
            }
        }
    }

    public static int check() {
        for (int i=0; i < h; i++) {
            for (int j=0; j < n; j++) {
                for (int k=0; k < m; k++) {
                    if (visited[i][j][k] == 0) {
                        return -1;
                    }

                    else if (visited[i][j][k] > result) {
                        result = visited[i][j][k];
                    }
                }
            }
        }
        return --result;
    }
}
