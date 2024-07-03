// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let input_cnt = 0;
	let input_data = []
	
	for await (const line of rl) {
		//console.log('Hello Goorm! Your input is', line);
		
		temp = line.split(" ").map((num) => Number(num));
		input_data.push(temp);
		
		input_cnt += 1;
		
		if (input_cnt === 2) {
			rl.close();
		}
	}
	
	// input data 처리
	const N = input_data[0][0];
	let D = input_data[0][1];
	
	let ants = input_data[1];
	ants.sort((a,b) => a-b);
	//console.log(ants)
	let start = 0;
	let end = 0;
	let length = 0;
	
	while (start < N && end < N) {
		if (ants[end] - ants[start] <= D) {
			length = Math.max(length,end-start+1);
			end += 1;
		}
		else {
			start += 1;
		}
	}
	console.log(N - length);
	process.exit();
})();
