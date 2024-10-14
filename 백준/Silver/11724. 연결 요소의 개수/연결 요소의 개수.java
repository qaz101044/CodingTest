import java.util.*;
import java.io.*;

public class Main {
	static int arr[][];
	static boolean node[];
	static int N, count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		arr = new int[N+1][N+1];
		node = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 무방향 그래프 특성
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		count = 0;
		for(int i=1; i<=N; i++) {	
			if(node[i] == false) {
				DFS(i);				
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static void DFS(int value) {
		
		if(node[value] == true) {
			return;
		}

		node[value] = true;
		for(int i=1; i<=N; i++) {
			if(arr[value][i] == 1) {
				DFS(i);
			}
		}
	}

}