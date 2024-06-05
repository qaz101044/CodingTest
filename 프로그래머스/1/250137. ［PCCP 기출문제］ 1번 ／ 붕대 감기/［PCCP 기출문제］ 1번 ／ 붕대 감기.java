class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int max_hp = health;
        int hp = max_hp;
        int time = 0;
        
        for (int i=0; i < attacks.length; i++) {
            int attack_time = attacks[i][0];
            int damage = attacks[i][1];
            
            // hp 최신화
            int serial_time = attack_time - time - 1;
            
            int extra_heal = (serial_time / bandage[0]) * bandage[2];
            int heal = serial_time * bandage[1];
            
            hp = hp + extra_heal + heal;
            if (hp > max_hp) {
                hp = max_hp;
            }
            
            // 적 공격
            hp = hp - damage;
            time = attack_time;
            
            // 사망 체크
            if (hp <= 0) {
                answer = -1;
                break;
            } else {
                answer = hp;
            }
        }
        
        return answer;
    }
}