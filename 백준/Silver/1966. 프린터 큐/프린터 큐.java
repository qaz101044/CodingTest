import java.io.*;
import java.util.*;

public class Main {

    static LinkedList<int[]> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        
        // 테스트 케이스의 수 만큼 반복
        for (int i=0; i<T; i++) {
            queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j=0; j < N; j++) {
                queue.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            sb.append(solution(M)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    static int solution(int M){
        int temp = 0;

        while(!queue.isEmpty()) {

            int[] first = queue.poll();
            boolean isMax = true;

            for (int k=0; k < queue.size(); k++) {
                
                if(first[1] < queue.get(k)[1]) {
                    queue.offer(first);

                    for (int l=0; l < k; l++) {
                        queue.offer(queue.poll());
                    }

                    isMax = false;
                    break;
                }
            }

            if (isMax == false){
                continue;
            }

            temp += 1;

            if (first[0] == M) {
                break;
            }
        }

        return temp;
    }
}
