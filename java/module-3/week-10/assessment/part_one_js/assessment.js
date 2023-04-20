/**
 * Write a function that takes in a string and an array of values, 
 * and returns a count of values in the array that exactly match the string.
 * 
 * Example 1: filteredCount('A', ['A', 0, 'B', 'A', 'A']) --> 3 ('A' is found 3 times)
 * Example 2: filteredCount('A', ['a', '1', 'B', 1]) --> 0 ('A' is not found - case sensitive)
 * Example 3: filteredCount('1', ['a', '1', 'B', 1]) --> 1 ('1' is found once as a string)
 * Example 4: filteredCount('A', []) --> 0
 */
function filteredCount(matchStr, arr) {
    let count = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === matchStr) {
            count++
        }
    }
    return count;
}

/**
 * Given a state code and an array of order objects, return a count of the orders 
 * for that state that have a status of 'In-Progress'.
 * 
 * Order objects have properties for state, status, weight, and cost.
 */
function inProgressOrders(stateCode, orderArray) {

    let count = 0;
    for (let order of orderArray) {
        if (order.state === stateCode && order.status === 'In-Progress') {
            count++;
        }
    }

    return count;
}

/**
 * Given a state code and an array of order objects, identify the number of orders
 * shipped to that state, the total weight, and the total sales amount from those
 * orders. Only consider orders with a status of 'Delivered' or 'Shipped'.
 * 
 * Order objects have properties for state, status, weight, and cost.
 * 
 * Return an object with properties for count, weight, and sales. 
 *   For example: {
 *     count: 5,
 *     weight: 42,
 *     sales: 29.50
 *   }
 */
function orderVolume(stateCode, orderArray) {
   
        let count = 0;
        let weight = 0;
        let sales = 0;
        for (let i=0; i<orderArray.length; i++){
        const order = orderArray[i]
        if(order.state === stateCode && (order.status === 'Delivered' || order.status === 'Shipped')){
            count++;
            weight += order.weight;
            sales += order.cost;
        }
    }
      return {count,weight,sales};
}