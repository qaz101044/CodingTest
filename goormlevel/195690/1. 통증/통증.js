const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input_data = [] 
rl.on('line', (line) => {
	input_data.push(Number(line));
	rl.close();
});

rl.on('close', () => {
	input = input_data[0];
	
	let bandage = 0;
	let medicine = 0;
	let painkiller = 0;
	
	let painkiller_num = Math.floor(input / 14);
	let input_2 = Math.floor(input % 14);
	
	let medicine_num = Math.floor(input_2 / 7);
	let input_3 = Math.floor(input_2 % 7);
	
	console.log(input_3 + medicine_num + painkiller_num);
})