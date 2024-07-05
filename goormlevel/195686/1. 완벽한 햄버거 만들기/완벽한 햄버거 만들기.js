const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input_data = [];
let N = -1;
let input_cnt = 0;
rl.on('line', (line) => {
	if (input_cnt === 0) {
		N = Number(line);
		input_cnt += 1;
	}
	else {
		input_data.push(line)
		input_cnt += 1;
	}
	if (input_cnt === 2) {
		rl.close();
	}
});

rl.on('close', () => {
	let board = input_data[0].trim().split(' ').map((num) => Number(num));
	
	let stack = []
	let chk = 0;
	let up_trend = 0;
	
	let max_v = -1;
	for (let i=0; i < N; i++) {
		let k = board[i];
		stack.push(k);
		
		if (k > max_v) {
			max_v = k;
		}
		
		if (up_trend === 0 && stack.length >= 2) {
			if (stack[i-1] > stack[i]) {
				up_trend = 1;
				continue;
			}
		}
		
		else if (up_trend === 1 && stack.length >= 2) {
			if (stack[i-1] < stack[i]) {
				chk += 1;
			}
		}	
	}
	
	//console.log(stack);
	
	if (chk >= 1) {
		console.log(0);
	}
	
	else {
		console.log(stack.reduce((acc,cur) => acc + cur,0));
	}
	
})