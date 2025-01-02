import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(strfry(st.nextToken(), st.nextToken()));
        }
    }

    public static String strfry(String A, String B) {
        if (A.length() != B.length()) {
            return "Impossible";
        }

        int[] arrA = new int[26];
        int[] arrB = new int[26];

        for (int i=0; i < B.length(); i++) {
            arrB[B.charAt(i) - 'a']++;
            arrA[A.charAt(i) - 'a']++;
        }

        for (int i=0; i < 26; i++) {
            if (arrA[i] != arrB[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
