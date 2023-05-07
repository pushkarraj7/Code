/**
 * @param {number} n
 * @return {Function} counter
 */
function createCounter(n) {
  return function counter() {
    return n++;
  };
}

const myCounter = createCounter(5);

console.log(myCounter()); // Output: 5
console.log(myCounter()); // Output: 6
console.log(myCounter()); // Output: 7

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */