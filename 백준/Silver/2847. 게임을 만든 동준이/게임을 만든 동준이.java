import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int count = 0;

        for (int i=0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i > 0; i--) {
            while (arr[i] <= arr[i-1]) {
                count += 1;
                arr[i-1] = arr[i-1] - 1;
            }
        }

        System.out.println(count);
    }
}
