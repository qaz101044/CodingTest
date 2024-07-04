// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

let input_data = [];
let K = 0;
let input_cnt = 0;
rl.on("line", function(line) {
	if (input_cnt === 0) {
		K = Number(line);
		input_cnt += 1;
	}
	else {
		input_data.push(line.trim().split(' ').map((num) => Number(num)));
	}
	if (input_cnt === K + 1){
		rl.close()
	}
}).on("close", function() {
	
	
	input_data.forEach((xyn) => {
		let [x,y,n] = xyn;
		
		let d = Math.abs(x) + Math.abs(y)
		
		let answer = "NO";
		if (d <= n && (n-d) % 2 === 0) {
			answer = "YES";
		}
		console.log(answer);
	})
	process.exit();
});