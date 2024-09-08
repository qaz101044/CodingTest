import java.util.*;
import java.io.*;

public class Main {
    
    public static int[][] arr;
    public static int[] answer = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];

        StringTokenizer st;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        slice(n,0,0);
        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    public static void slice(int size, int n, int m){

        if(numCheck(size,n,m)){
            if(arr[n][m] == -1){
                answer[0]++;
            }else if(arr[n][m] == 0){
                answer[1]++;
            }else{
                answer[2]++;
            }
            
        }else{
            int newsize = size/3;

            slice(newsize, n, m);
            slice(newsize, n,m+newsize);
            slice(newsize, n,m+newsize*2);
            
            slice(newsize, n+newsize, m);
            slice(newsize, n+newsize,m+newsize);
            slice(newsize, n+newsize,m+newsize*2);
            
            slice(newsize, n+newsize*2, m);
            slice(newsize, n+newsize*2,m+newsize);
            slice(newsize, n+newsize*2,m+newsize*2);
        }
    }

    public static boolean numCheck(int size, int n, int m){
        int first = arr[n][m];
        boolean check = true;
        for(int i = n; i < n+size; i++){
            for(int j = m; j < m+size; j++){
                if(first != arr[i][j]){
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
}