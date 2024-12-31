import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] arr = input.toCharArray();
        int p = 0;
        int answer = 1;

        while(p < arr.length) {
            String num = Integer.toString(answer);

            for (int i=0; i < num.length(); i++) {
                if (num.charAt(i) == arr[p]) {
                    p++;
                }

                if (p >= arr.length) {
                    break;
                }
            }

            answer += 1;
        }

        System.out.println(answer-1);
    }
}
