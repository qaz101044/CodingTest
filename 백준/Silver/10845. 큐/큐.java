import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>(); 

        for (int i=0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            // push인 경우
            if (arr.length == 2) {
                q.add(Integer.parseInt(arr[1]));
            }

            else {
                if (arr[0].equals("pop")) {
                    if (!q.isEmpty()) {
                        System.out.println(q.poll());
                    }
                    else {
                        System.out.println(-1);
                    }
                }

                else if (arr[0].equals("front")) {
                    if (!q.isEmpty()) {
                        System.out.println(q.peek());
                    }
                    else {
                        System.out.println(-1);
                    }
                }

                else if (arr[0].equals("back")) {
                    if (!q.isEmpty()) {
                        int K = q.size();
                        for (int j=0; j < K-1; j++) {
                            q.add(q.poll());
                        }
                        System.out.println(q.peek());
                        q.add(q.poll());
                    }
                    else {
                        System.out.println(-1);
                    }
                }

                else if (arr[0].equals("size")) {
                    System.out.println(q.size());
                }

                else if (arr[0].equals("empty")) {
                    if (q.isEmpty()) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                }
            }
        }
    }
}
