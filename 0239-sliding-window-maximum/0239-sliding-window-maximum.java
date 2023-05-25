class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0)
      return new int[0];

    int n = nums.length;
    int[] result = new int[n - k + 1];
    int ri = 0;

    Deque < Integer > deque = new ArrayDeque < > ();

    for (int i = 0; i < n; i++) {
      // Remove elements outside of the current window
      while (!deque.isEmpty() && deque.peek() < i - k + 1)
        deque.poll();

      // Remove smaller elements from the deque
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
        deque.pollLast();

      deque.offer(i);

      // The first element in the deque will always be the maximum for the current window
      if (i >= k - 1)
        result[ri++] = nums[deque.peek()];
    }
    return result;
  }
}