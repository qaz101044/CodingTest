const fs = require('fs');
// TODO : 제출 시 경로 변환 필수 "/dev/stdin"
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

// 입력값 정리
const K = input[0];

function get_sum(K) {
    let result = K.split('').reduce((acc,cur) => acc + Number(cur), 0);
    return String(result);
}

function solution(K,cnt) {
    const answer = [];

    if(K.length === 1) {
        answer.push(cnt);
        if (Number(K) % 3 !== 0) {
            answer.push('NO');
        }
        else {
            answer.push('YES');
        }
        return answer.join('\n');
    }

    return solution(get_sum(K),cnt+1);
}

console.log(solution(K,0))