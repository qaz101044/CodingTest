// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let N = 0;
	let input_cnt = 0;
	let board = []
	for await (const line of rl) {
		// console.log('Hello Goorm! Your input is', line);
		if (input_cnt === 0) {
			N = Number(line);
			input_cnt += 1;
		}
		else {
			input_temp = line.trim().split(' ').map((num) => Number(num));
			board.push(input_temp);
			input_cnt += 1;
		}
		if (input_cnt === N + 1) {
			rl.close();
		}
	}
	
	board.sort((a,b) => a[1]-b[1]);
	
	let last_end_time = -1;
	let cnt = 0;
	
	for (let i=0; i < N; i++) {
		if (board[i][0] > last_end_time) {
			cnt += 1;
			last_end_time = board[i][1];
		}
	}
	console.log(cnt);
	process.exit();
})();
