const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input_data = [];
let input_cnt = 0
let N = 0;
let K = 0;
rl.on('line', (line) => {
	if (input_cnt === 0) {
		let temp = line.trim().split(' ').map((num) => Number(num));
		N = temp[0];
		K = temp[1];
		input_cnt += 1;
	}
	else {
		input_data.push(line);
		input_cnt += 1;
	}
	if (input_cnt === N + 1) {
		rl.close();
	}
});

rl.on('close', () => {
	let board = input_data.map(line => line.trim().split(' ').map((num) => Number(num)));
	// 8방향 : 북/북동/동/동남 // 남/남서/서/서북
	const dx = [-1,-1,0,1,1,1,0,-1];
	const dy = [0,1,1,1,0,-1,-1,-1];
	
	let cnt_board = []
	for (let i=0; i < N; i++) {
		cnt_board.push(Array(N).fill(0));
	}
	
	let answer = 0;
	
	for (let i=0; i < N; i++) {
		for (let j=0; j < N; j++) {
			let cloud_cnt = 0;
			let [sx,sy] = [i,j];
			
			if (board[i][j] === 0) {
				for (let k=0; k < 8; k++) {
					let nx = sx + dx[k];
					let ny = sy + dy[k];

					if (0 <= nx && nx < N && 0 <= ny && ny < N ) {
						if (board[nx][ny] === 1) {
							cloud_cnt += 1;
						}
					}
				}
				cnt_board[i][j] = cloud_cnt;
				if (cloud_cnt === K) {
					answer += 1;
				}
			}
		}
	}
	
	console.log(answer);
})