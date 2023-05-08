/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
  var ret = [];

  for (var i = 0; i < arr.length; i++) {
    ret.push(fn(arr[i], i));
  }

  return ret;
};