// 이모티콘 플러스 서비스 가입자를 최대로

class Solution {
    
    static int[] discount = {10,20,30,40};
    static int maxSubscribers;
    static int maxCost;
    
    public int[] solution(int[][] users, int[] emoticons) {
        findResult(0,emoticons.length, new int[emoticons.length],users,emoticons);
        return new int[]{maxSubscribers,maxCost};
    }
    
    public void findResult(int index, int emoticonsLength, int[] discounts, int[][] users, int[] emoticons){
        if (index == emoticonsLength){
            int subscribe = 0;
            int cost = 0;
            
            for (int[] user : users) {
                int userDiscountRate = user[0];
                int userMaxCost = user[1];
                
                int sum = 0;
                
                for (int i=0; i < emoticons.length; i++) {
                    if (discounts[i] >= userDiscountRate) {
                        sum += (emoticons[i]/100)*(100-discounts[i]);
                    }
                }
                if (sum >= userMaxCost) {
                    subscribe += 1;
                }
                
                else {
                    cost += sum;
                }
            }
            
            if (subscribe > maxSubscribers) {
                maxSubscribers = subscribe;
                maxCost = cost;
            }
            
            else if (subscribe == maxSubscribers) {
                maxCost = Math.max(maxCost,cost);
            }
            return;
        }
        
        for (int i=0; i < 4; i++) {
            discounts[index] = discount[i];
            findResult(index+1,emoticonsLength,discounts,users,emoticons);
        }
        
    }
}