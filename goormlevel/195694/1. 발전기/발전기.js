const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input_data = []
rl.on('line', (line) => {
	input_data.push(line);
	if (input_data.length == input_data[0] + 1) {
		rl.close();
	}
});

rl.on('close', () => {
	let N = Number(input_data[0]);
	let board = input_data.slice(1).map(line => line.split(' ').map((num) => Number(num)));
	let visited = []
	
	for (let i=0; i < N; i++) {
		visited.push(Array(N).fill(0));
	}
	
	let e_cnt = 0;
	
	// 북,동,남,서
	const dx = [-1,0,1,0];
	const dy = [0,1,0,-1];
	
	for (let i=0; i < N; i++) {
		for (let j=0; j < N; j++) {
			if (board[i][j] === 1 && visited[i][j] === 0) {
				e_cnt += 1;
				visited[i][j] = 1;
				let q = [[i,j]];
				
				while (q.length) {
					let [sx,sy] = q.shift();
					
					for(let k=0; k < 4; k++) {
						let nx = sx + dx[k];
						let ny = sy + dy[k];
						
						if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] === 1 && visited[nx][ny] === 0) {
							q.push([nx,ny]);
							visited[nx][ny] = 1;
						}
					}
				}
			}
		}
	}
	console.log(e_cnt);
	
})