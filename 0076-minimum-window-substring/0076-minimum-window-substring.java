class Solution {
    public String minWindow(String s1, String s2) {
        String ans ="";
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch,0)+1);
        }
        int mct=0;
        int dmct=s2.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i=-1;
        int j=-1;
        while(true){
            boolean f1=false;
            boolean f2=false;
            //acquire
            while(i<s1.length()-1 && mct<dmct){
                i++;
                char ch=s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){
                    mct++;
                }
                f1=true;
            }
            //collect answer and release
            while(j<i && mct==dmct){
                String pans=s1.substring(j+1,i+1);
                if(ans.length()==0 || pans.length()<ans.length()){
                    ans=pans;
                }
                j++;
                char ch=s1.charAt(j);
                if(map1.get(ch)==1){
                    map1.remove(ch);
                }else{
                    map1.put(ch, map1.get(ch)-1);
                }
                if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0)){
                    mct--;
                }
                f2=true;
            }
            if(f1==false && f2==false){
                break;
            }
        }
        return ans;
    }
}


//O(n+m)
// class Solution {
//     public String minWindow(String s, String t) {
//         Map<Character, Integer> targetFreq = new HashMap<>();
//         Map<Character, Integer> windowFreq = new HashMap<>();

//         // Initialize targetFreq with character frequencies of t
//         for (char c : t.toCharArray()) {
//             targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
//         }

//         int left = 0;
//         int right = 0;
//         int minLength = Integer.MAX_VALUE;
//         int minLeft = 0;
//         int matched = 0;
//         int required = targetFreq.size();

//         while (right < s.length()) {
//             char c = s.charAt(right);
//             windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

//             // Check if the current character is in targetFreq and has been matched
//             if (targetFreq.containsKey(c) && windowFreq.get(c).equals(targetFreq.get(c))) {
//                 matched++;
//             }

//             // Try to minimize the window by moving the left pointer
//             while (matched == required) {
//                 // Update the minimum window size and indices
//                 if (right - left + 1 < minLength) {
//                     minLength = right - left + 1;
//                     minLeft = left;
//                 }

//                 char leftChar = s.charAt(left);
//                 windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

//                 // Check if a required character is no longer included in the window
//                 if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
//                     matched--;
//                 }
//                 left++;
//             }
//             right++;
//         }
//         return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
//     }
// }


//O(n)
// class Solution {
//     public String minWindow(String s, String t) {
//         Map<Character, Integer> target = new HashMap<>();
//         for (char c : t.toCharArray()) {
//             target.put(c, target.getOrDefault(c, 0) + 1);
//         }
        
//         int left = 0;
//         int right = 0;
//         int minLength = Integer.MAX_VALUE;
//         int minLeft = 0;
//         int count = t.length();
        
//         while (right < s.length()) {
//             char c = s.charAt(right);
//             if (target.containsKey(c)) {
//                 if (target.get(c) > 0) {
//                     count--;
//                 }
//                 target.put(c, target.get(c) - 1);
//             }
//             right++;
            
//             while (count == 0) {
//                 if (right - left < minLength) {
//                     minLength = right - left;
//                     minLeft = left;
//                 }
//                 char leftChar = s.charAt(left);
//                 if (target.containsKey(leftChar)) {
//                     target.put(leftChar, target.get(leftChar) + 1);
//                     if (target.get(leftChar) > 0) {
//                         count++;
//                     }
//                 }
//                 left++;
//             }
//         }
        
//         if (minLength == Integer.MAX_VALUE) {
//             return "";
//         }
//         return s.substring(minLeft, minLeft + minLength);
//     }
// }