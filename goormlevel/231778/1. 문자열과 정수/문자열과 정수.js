// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let temp = []
	for await (const line of rl) {
		//console.log('Hello Goorm! Your input is', line);
		temp.push(Number(line))
		rl.close();
	}
	//console.log(temp)
	let num_sum = 0;
	let string_sum = ''
	temp.forEach(num => {
		num_sum += num;
	})
	temp.forEach(num => {
		string_sum += String(num);
	})
	console.log(string_sum);
	console.log(num_sum);
	
	process.exit();
})();
