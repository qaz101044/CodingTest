import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s=0, e=0, sum=0, cnt=0;

        while(true) {

            // 합이 m이상이 되면
            if(sum >= m) {
                sum -= arr[s];
                s++;

            // e가 배열 끝까지 도달
            } else if (e == n) {
                break;
            }

            else {
                sum += arr[e];
                e++;
            }
            if(sum == m) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
