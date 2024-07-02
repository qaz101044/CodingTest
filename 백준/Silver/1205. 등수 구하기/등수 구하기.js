const fs = require('fs');
// TODO : 제출 시 경로 변환 필수
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

// input값 정제
const [N,Tae,P] = input[0].split(' ').map((num) => Number(num));
if (N === 0) {
    console.log(1);
    process.exit();
}
const arr = input[1].split(' ').map((num) => Number(num));

function solution(N,Tae,P,arr) {

    if (N === 0) {
        return 1;
    }

    arr.push(Tae);

    const arr_sorted = arr.sort((a,b) => b - a); // 내림차순 정렬
    let idx_arr = [];
    let idx = arr_sorted.indexOf(Tae);

    while (idx !== -1) {
        idx_arr.push(idx + 1);
        idx = arr_sorted.indexOf(Tae,idx + 1);
    }
    if (idx_arr[idx_arr.length - 1] > P) {
        return -1;
    }
    else {
        return idx_arr[0];
    }
}

console.log(solution(N,Tae,P,arr));