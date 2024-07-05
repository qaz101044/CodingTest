const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input_data = [];
let N = -1;
let K = -1;
let input_cnt = 0;

rl.on('line', (line) => {
	if (input_cnt === 0) {
		[N,K] = line.trim().split(' ').map((num) => Number(num));
		input_cnt += 1;
	}
	else {
		input_data.push(line);
		input_cnt += 1;
	}
	if (input_cnt === N + K + 1) {
		rl.close();
	}
});

rl.on('close', () => {
	let board = input_data.slice(0,N).map(line => line.trim().split(' ').map((num) => String(num)));
	let target = input_data.slice(N).map(line => line.trim().split(' ').map((num) => Number(num)));
	let bomb_board = [];
	for (let i=0; i < N; i++) {
		bomb_board.push(Array(N).fill(0));
	}
	// 4 방향 : 북/동/남/서
	const dx = [0,-1,0,1,0];
	const dy = [0,0,1,0,-1];
	
	for (let i=0; i < K; i++) {
		let [x,y] = target[i];
		x -= 1;
		y -= 1;
		
		for (let k=0; k < 5; k++) {
			let nx = x + dx[k];
			let ny = y + dy[k];
			
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (board[nx][ny] === '@') {
					bomb_board[nx][ny] += 2;
				}
				
				else if (board[nx][ny] !== '@' && board[nx][ny] !== '#') {
					bomb_board[nx][ny] += 1;
				}
			}
		}
	}
	let max_cnt = 0;
	
	for (let i=0; i < N; i++) {
		for (let j=0; j < N; j++) {
			if (bomb_board[i][j] > max_cnt) {
				max_cnt = bomb_board[i][j];
			}
		}
	}
	console.log(max_cnt);
	process.exit();
})