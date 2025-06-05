function fibonacci(n: number): number {
    if (n <= 0) return 0;
    if (n === 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

function sumFibonacci(n: number): number {
    let sum: number = 0;

    console.log(`Dãy Fibonacci từ F(0) đến F(${n}):`);
    for (let i = 0; i <= n; i++) {
        const fib = fibonacci(i);
        console.log(`F(${i}) = ${fib}`);
        sum += fib;
    }

    return sum;
}

const n = 5;
const result = sumFibonacci(n);
console.log(`Tổng các số Fibonacci từ F(0) đến F(${n}) là: ${result}`);
