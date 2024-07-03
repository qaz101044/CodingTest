const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
rl.on('line', (line) => {
    input.push(line);
});

rl.on('close', () => {
    const [N, M] = input[0].split(' ').map(Number);
    let beforeHeights = input[1].split(' ').map(Number);
    let rainyDay = input.slice(2).map(line => line.split(' ').map(Number));
    let waterHeights  = new Array(N).fill(0);

    for (let i = 0; i < M; i++) {
        const [start, end] = rainyDay[i];
        for (let j = start - 1; j < end; j++) waterHeights [j]++;
      
        if ((i + 1) % 3 === 0) {
          	let recentRainyDays = new Set();
            for (let k = Math.max(0, i - 2); k <= i; k++) {
                const [s, e] = rainyDay[k];
                for (let j = s - 1; j < e; j++) {
                    recentRainyDays.add(j);
                }
            }
          	for(let idx of recentRainyDays){
              	if(waterHeights[idx] > 0) waterHeights[idx]--;
            }
        }
    }
  
    let finalHeights = beforeHeights.map((height, idx) => height + waterHeights [idx]);
    console.log(finalHeights.join(" "));
});
