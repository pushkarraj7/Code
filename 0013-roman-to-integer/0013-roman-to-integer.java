class Solution {
  public int romanToInt(String s) {
    int result = 0;
    if (s == null || s.length() == 0)
      return result;
    Map < Character, Integer > map = new HashMap < > ();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int prev = map.get(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      int current = map.get(s.charAt(i));
      if (prev < current)
        result -= prev;
      else
        result += prev;
      prev = current;
    }
    result += prev;
    return result;
  }

}