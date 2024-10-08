import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] minArr = new int[n];
		
		for(int i = 0; i < n; i++) {
			int p = sc.nextInt();
			int l = sc.nextInt();
			Integer[] mList = new Integer[p];
            
			for(int j = 0; j < p; j++) {
				mList[j] = sc.nextInt();
			}
            
			if(p < l) {
				minArr[i] = 1;
				continue;
			}
            
            else {
				Arrays.sort(mList, Collections.reverseOrder());
				minArr[i] = mList[l-1];
			}
		}
		
		Arrays.sort(minArr);
		int cnt = 0;
		int mSum = 0;
        
		for(int i = 0; i < n; i++) {
			mSum += minArr[i];
			if(mSum > m) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}