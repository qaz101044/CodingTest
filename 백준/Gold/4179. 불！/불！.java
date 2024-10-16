import java.util.*;
import java.io.*;

public class Main {

    // 북 동 남 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        int[][] visited = new int[N][M];
        int[][] burned = new int[N][M];

        Queue<int[]> person = new LinkedList<>(); // 사람 큐
        Queue<int[]> fire = new LinkedList<>(); // 화재 큐

        for (int i=0; i < N; i++) {
            String input = br.readLine();
            for (int j=0; j < M; j++) {
                board[i][j] = input.charAt(j);
                /*
                 * # : 벽
                 * . : 지나갈 수 있는 공간
                 * J : 지훈이(사람)
                 * F : 불
                 */
                if (board[i][j] == 'J') {
                    person.add(new int[]{i,j});
                    visited[i][j] = 1;
                }

                else if (board[i][j] == 'F') {
                    fire.add(new int[]{i,j});
                    burned[i][j] = 1;
                }
            }
        }

        // input값 체크
        //System.out.println(Arrays.deepToString(board));

        // 불 BFS
        while (!fire.isEmpty()) {
            int size = fire.size();
            for (int i=0; i < size; i++) {
                int[] s = fire.poll();
                int x = s[0];
                int y = s[1];

                for (int j=0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // 범위를 벗어나거나 , 벽(#)이거나, 이미 방문했으면 pass
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == '#' || burned[nx][ny] != 0) {
                        continue;
                    }

                    burned[nx][ny] = burned[x][y] + 1;
                    fire.add(new int[]{nx,ny});
                }
            }
        }

        // 사람 BFS
        while (!person.isEmpty()) {
            int size = person.size();
            for (int i=0; i < size; i++) {
                int[] s = person.poll();
                int x = s[0];
                int y = s[1];

                for (int d=0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // board 벗어나면 탈출
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        System.out.println(visited[x][y]);
                        return;
                    }

                    // 이미 방문했거나, 벽(#)이거나, 불보다 먼저 못 왔으면 pass
                    if (visited[nx][ny] != 0 || board[nx][ny] == '#' || (visited[x][y] + 1 >= burned[nx][ny] && burned[nx][ny] != 0)) {
                        continue;
                    }

                    visited[nx][ny] = visited[x][y] + 1;
                    person.add(new int[]{nx,ny});
                }
            }
        }

        // board 탈출 실패
        System.out.println("IMPOSSIBLE");
        //System.out.println(Arrays.deepToString(visited));
        //System.out.println(Arrays.deepToString(burned));
    }
}
