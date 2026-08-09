/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map();

    return function(...args) {

        // Convert arguments into a key
        const key = JSON.stringify(args);

        // If result already exists
        if (cache.has(key)) {
            return cache.get(key);
        }

        // Calculate result
        const result = fn(...args);

        // Store result
        cache.set(key, result);

        return result;
    };
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */