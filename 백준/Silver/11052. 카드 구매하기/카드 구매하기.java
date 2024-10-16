import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[1001];
        int[] D = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i <= N; i++) {
            for (int j=1; j <= i; j++) {
                D[i] = Math.max(D[i],D[i-j] + P[j]);
            }
        }

        System.out.println(D[N]);
    }
}
