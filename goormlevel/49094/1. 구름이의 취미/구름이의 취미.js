// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let N = 0;
	for await (const line of rl) {
		//console.log('Hello Goorm! Your input is', line);
		N = BigInt(line);
		rl.close();
	}
	
	let N_sum = BigInt((N*(N+1n)/2n) **2n) % BigInt(1000000007n);
	console.log(`${N_sum}`.split('n')[0]);
	
	process.exit();
})();
