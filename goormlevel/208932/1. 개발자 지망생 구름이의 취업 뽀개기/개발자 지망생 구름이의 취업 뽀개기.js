// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let input_data = []
	let N = 0;
	let level_arr = []
	let input_cnt = 0;
	
	for await (const line of rl) {
		//console.log('Hello Goorm! Your input is', line);
		if (input_cnt === 0) {
			N = Number(line);
			input_cnt += 1;
		}
		
		else if (input_cnt === 1) {
			level_arr = line.split(" ").map((num) => Number(num));
			input_cnt += 1;
		}
		
		else {
			temp_arr = line.split(" ").map((num) => Number(num));
			input_data.push(temp_arr);
			input_cnt += 1;
		}
		
		if (input_cnt == 12) {
			rl.close();
		}
	}
	
	// input date 확인
	//console.log(N);
	//console.log(level_arr);
	//console.log(input_data)
	//process.exit();
	
	input_data.sort((a,b) => a[0]-b[0] || a[1]-b[1]);
	
	let picked = [];
	for (let i=0; i < level_arr.length; i++) {
		let pick_level = i+1;
		let pick_cnt = level_arr[i];
		
		for (let j=0; j < input_data.length; j++) {
			if (pick_level === input_data[j][0]) {
				picked.push(input_data[j])
				pick_cnt -= 1;
			}
			
			if (pick_cnt <= 0) {
				break;
			}
		}
	}
	let answer = 0;
	
	for (let i=0; i < picked.length-1; i++) {
		// 난이도가 같을 경우
		if (picked[i][0] === picked[i+1][0]) {
			answer += picked[i][1];
			answer += picked[i+1][1] - picked[i][1];
		}
		// 난이도가 다를 경우
		else {
			answer += picked[i][1];
			answer += 60;
		}
	}
	answer += picked[picked.length-1][1];
	
	console.log(answer);
	
	
})();
