import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
        int W = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        String[] inputArr = br.readLine().split(" ");
        Queue<Integer> ready = new LinkedList<>(); // 트럭 대기열
        Queue<Integer> bridge = new LinkedList<>(); // 다리 위의 트럭 이동;
        Queue<Integer> weight = new LinkedList<>(); // 다리 위의 트럭 무게 

        for (String s : inputArr) {
            ready.add(Integer.parseInt(s));
        }

        int answer = 0;

        while (!bridge.isEmpty() || !ready.isEmpty()) {
            // 대기 중인 트럭이 존재하고 다리에 진입할 조건이 갖춰졌을 때
            if (ready.size() > 0 && weight.stream().mapToInt(Integer::intValue).sum() < L) {
                int tempL = weight.stream().mapToInt(Integer::intValue).sum();
                int t = tempL + ready.peek();

                if (t <= L) {
                    int n = ready.poll();
                    bridge.add(W);
                    weight.add(n);
                } 

            }

            // 다리 위의 트럭 1칸씩 이동
            if (!bridge.isEmpty()) {
                int size = bridge.size();
                for (int i=0; i < size; i++) {
                    int current = bridge.poll();

                    // 0되면 bridge 삽입 x 및 weight poll처리리
                    if (current - 1 == 0) {
                        weight.poll();
                    }

                    else {
                        bridge.add(current-1);
                    }
                }
            }

            // 1초 경과
            answer += 1;

        }

        System.out.println(answer+1);
        //System.out.println(ready);
        //System.out.println(bridge);


    }
}
