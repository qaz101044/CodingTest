import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N = 지난 일수, X = 기간
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String[] arr = br.readLine().split(" ");

        int maxValue = 0;
        int countMax = 0;

        int tempSum = 0;
        int cnt = 0;

        for (int i=0; i < arr.length; i++) {
            int temp = Integer.parseInt(arr[i]);

            // X보다 작을 경우
            if (cnt < X) {
                tempSum += temp;
                cnt++;
            }

            else {
                tempSum += temp;
                tempSum -= Integer.parseInt(arr[i-X]);
            }

            if (cnt == X && maxValue < tempSum) {
                countMax = 1;
                maxValue = tempSum;
            }

            else if (cnt == X && maxValue == tempSum) {
                countMax++;
            }
        }

        if (maxValue != 0) {
            System.out.println(maxValue);
            System.out.println(countMax);
        }

        else {
            System.out.println("SAD");
        }
        
    }
}
