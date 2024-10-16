import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 0;

        char[] charArr = str.toCharArray();
        int[] intArr = new int[10];
        Arrays.fill(intArr,0);

        for (int i=0; i<charArr.length; i++) {
            int k = -1;
            if (Character.getNumericValue(charArr[i]) == 6 || Character.getNumericValue(charArr[i]) == 9) {
                intArr[6] -= 1;
                k = 6;
            }
            else {
                intArr[Character.getNumericValue(charArr[i])] -= 1;
                k = Character.getNumericValue(charArr[i]);
            }

            if (intArr[k] < 0) {
                answer += 1;
                for (int j=0; j<10; j++) {
                    if (j == 6) {
                        intArr[6] += 2;
                    }

                    else {
                        intArr[j] += 1;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(intArr));
        System.out.println(answer);

    }
}