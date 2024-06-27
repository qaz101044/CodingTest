class Solution {
    public int solution(int n, String control) {
        int answer = n;
        String[] control_arr = control.split("");
        
        for (int i=0; i < control_arr.length; i++) {
            
            if (control_arr[i].equals("w")) {
                answer += 1;
            }
            else if (control_arr[i].equals("s")) {
                answer -= 1;
            }
            
            else if (control_arr[i].equals("d")) {
                answer += 10;
            }
            
            else if (control_arr[i].equals("a")) {
                answer -= 10;
            }
        }
        
        
        return answer;
    }
}