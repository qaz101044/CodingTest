// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let a = -1;
	let b = -1;
	
	for await (const line of rl) {
		//console.log('Hello Goorm! Your input is', line);
		[a,b] = line.trim().split(' ').map((num) => Number(num));
		rl.close();
	}
	
	if (a !== b) {
		console.log(2)
	}
	
	else {
		for (let i=2; i**0.5< a; i++) {
			if (a % i === 0) {
				console.log(i);
				break;
			}
			
		}
	}
	
	process.exit();
})();
