import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static String[][] board;
    static int[][] visited;

    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();

    // 북 동 남 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N][M];
        visited = new int[N][M];

        // 최초 보드 설정
        for (int i=0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j=0; j < M; j++) {
                board[i][j] = temp[j];

                if (board[i][j].equals("S")) {
                    q.add(new int[] {i,j,0});
                }

                else if (board[i][j].equals("*")) {
                    water.add(new int[] {i,j});
                }
            }
        }

        bfs();
        if (answer == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(answer);
        }
    }

    public static void bfs() {

        while (!q.isEmpty()) {
            // 물 움직임
            int L = water.size();
            for (int i=0; i < L; i++) {
                int[] s = water.poll();
                int sx = s[0];
                int sy = s[1];

                for (int d=0; d < 4; d++) {
                    int nx = sx + dx[d];
                    int ny = sy + dy[d];

                    if (nx >= 0 && nx < N && ny < M && ny >= 0 && board[nx][ny].equals(".")) {
                        board[nx][ny] = "*";
                        water.add(new int[] {nx,ny});
                    }
                }
            }

            L = q.size();
            for (int i=0; i < L; i++) {
                int[] s = q.poll();
                int sx = s[0];
                int sy = s[1];
                int time = s[2];

                for (int d=0; d < 4; d++) {
                    int nx = sx + dx[d];
                    int ny = sy + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (board[nx][ny].equals("D")) {
                            answer = Math.min(answer,time + 1);
                            return;
                        }

                        else if (board[nx][ny].equals(".")) {
                            board[nx][ny] = "S";
                            q.add(new int[] {nx,ny,time+1});
                        }
                    }
                }
            }
        }
    }
}
