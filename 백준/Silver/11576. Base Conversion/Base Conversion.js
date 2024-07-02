const fs = require('fs');
// TODO : 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

// 입력 값 정리
const [a,b] = input[0].split(' ').map((num) => Number(num));
const arr = input[2].split(' ').map((num) => Number(num));

// 풀이
function solution(a,b,arr) {
    const answer = [];
    let ten_num = 0;
    arr.forEach((num,i) => {
        ten_num += a ** (arr.length -1 -i) * num;
    });

    while (ten_num > 0) {
        answer.push(ten_num % b);
        ten_num = Math.floor(ten_num / b)
    }

    answer.reverse();
    return answer.join(' ');
}
console.log(solution(a,b,arr));