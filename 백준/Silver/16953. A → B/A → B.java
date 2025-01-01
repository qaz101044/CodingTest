import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 1;
        int pass = 0;
        while (B >= A) {
            if (B == A) {
                pass++;
                break;
            }

            if (B % 10 == 1 && B >= 10) {
                B = B / 10;
                answer += 1;
            }

            else if (B % 2 == 0) {
                B = B / 2;
                answer += 1;
            }

            else {
                break;
            }
        }

        if (pass == 0) {
            System.out.println(-1);
        }

        else {
            System.out.println(answer);
        }
    }
}
