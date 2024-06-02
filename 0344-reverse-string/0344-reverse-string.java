// class Solution {
//     public void reverseString(char[] s) {
//         int left = 0;
//         int right = s.length - 1;
        
//         while (left < right) {
//             char temp = s[left];
//             s[left] = s[right];
//             s[right] = temp;
            
//             left++;
//             right--;
//         }
//     }
// }


class Solution {
  public void reverseString(char[] s) {
    int l = 0;
    int r = s.length - 1;

    while (l < r) {
      char temp = s[l];
      s[l++] = s[r];
      s[r--] = temp;
    }
  }
}