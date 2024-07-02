function solution(num_list) {
    let answer = 0;
    let arr_odd = [];
    let arr_even = [];
    
    for (let i=0; i < num_list.length; i++) {
        if (num_list[i] % 2 == 0) {
            arr_even.push(num_list[i]);
        }
        else {
            arr_odd.push(num_list[i]);
        }
    }
    return Number(arr_odd.join('')) + Number(arr_even.join(''));
}