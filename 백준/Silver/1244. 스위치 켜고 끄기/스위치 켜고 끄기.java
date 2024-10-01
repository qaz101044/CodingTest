import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int[] switches = new int[total];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<total; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        for(int i=0; i<studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            // 남학생인 경우
            if (gender == 1) {
                for (int j=0; j<total; j++) {

                    if ((j+1) % number == 0) {
                        if (switches[j] == 0) {
                            switches[j] = 1;
                        }
                        else {
                            switches[j] = 0;
                        }
                    }
                }
            }

            // 여학생인 경우
            else {
                if (switches[number-1] == 0) {
                    switches[number-1] = 1;
                }
                else {
                    switches[number-1] = 0;
                }

                for(int j=1; j< total/2; j++) {
                    if (number - 1 + j >= total || number - 1 - j < 0) {
                        break;
                    }
                    if (switches[number - 1 - j] == switches[number - 1 + j]) {
                        switches[number - 1 - j] = switches[number - 1 - j] == 0 ? 1 : 0;
						switches[number - 1 + j] = switches[number - 1 + j] == 0 ? 1 : 0;
                    }

                    else break;
                }
            }

        }

        // 출력
        for(int i=0; i<total; i++) {
			System.out.print(switches[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
    }
}
