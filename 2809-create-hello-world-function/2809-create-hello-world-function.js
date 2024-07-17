/**
 * @return {Function}
 */
var createHelloWorld = function() {
    const greeting = "Hello World";
    return function() {
        return greeting;
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */