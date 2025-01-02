import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int glacierCount;
    static int[][] board;
    static int[][] meltBoard;
    static int[][] visited;

    // 북 동 남 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;
    static int pass;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        // 보드 판 최초 입력
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        // 빙산이 두 덩어리 이상으로 분리되거나 다 녹거나
        while (true) {

            // meltBoard 초기화
            meltBoard = new int[N][M];
            visited = new int[N][M];
            glacierCount = 0;

            // 바닷물과 인접한 타일 1개마다 빙하가 1씩 녹도록 meltBoard 갱신신
            for (int i=1; i < N-1; i++) {
                for (int j=1; j < M-1; j++) {
                    if (board[i][j] > 0) {
                        meltBoarding(i,j);
                    }
                }
            }

            // 일괄적으로 melt처리
            melt();
            answer += 1;

            // 빙산 두 덩이 이상인지 조사
            for (int i=1; i < N-1; i++) {
                for (int j=1; j < M-1; j++) {
                    if (board[i][j] > 0 && visited[i][j] == 0) {
                        bfs(i,j);
                    }
                }
            }

            if (glacierCount >= 2) {
                break;
            }

            int chk = 0;
            for (int i=1; i < N-1; i++) {
                for (int j=1; j < M-1; j++) {
                    if (board[i][j] > 0) {
                        chk += 1;
                        break;
                    }
                }
            }

            if (chk == 0) {
                pass += 1;
                break;
            }

            //for (int i=0; i < board.length; i++) {
            //    System.out.println(Arrays.toString(board[i]));
            //}
        }

        if (pass == 0) {
            System.out.println(answer);
        }
        else {
            System.out.println(0);
        }
    }

    // meltBoard 계산
    public static void meltBoarding(int x, int y) {

        int meltCount = 0;
        for (int d=0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (board[nx][ny] == 0) {
                meltCount += 1;
            }
        }

        meltBoard[x][y] += meltCount;
    }

    // melt 일괄 처리
    public static void melt() {
        for (int i=1; i < N-1; i++) {
            for (int j=1; j < M-1; j++) {
                if (board[i][j] > 0) {
                    board[i][j] -= meltBoard[i][j];
                    if (board[i][j] < 0) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visited[x][y] = 1;

        while (!q.isEmpty()) {
            int[] s = q.poll();
            int sx = s[0];
            int sy = s[1];

            for (int d=0; d < 4; d++) {
                int gx = sx + dx[d];
                int gy = sy + dy[d];

                if (board[gx][gy] > 0 && visited[gx][gy] == 0) {
                    visited[gx][gy] = 1;
                    q.add(new int[] {gx,gy});
                }
            }
            //System.out.println(Arrays.toString(s));
        }

        glacierCount += 1;

    }
}
