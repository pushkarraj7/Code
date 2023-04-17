class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }

    int m = num1.length();
    int n = num2.length();
    int[] ans = new int[m + n];

    for (int i = m - 1; i >= 0; i--) {
      int x = num1.charAt(i) - '0';
      for (int j = n - 1; j >= 0; j--) {
        int y = num2.charAt(j) - '0';
        int prod = x * y;
        int p1 = i + j;
        int p2 = i + j + 1;
        int sum = prod + ans[p2];
        ans[p2] = sum % 10;
        ans[p1] += sum / 10;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ans.length; i++) {
      if (i == 0 && ans[i] == 0)
        continue;
      sb.append(ans[i]);
    }
    return sb.toString();
  }
}