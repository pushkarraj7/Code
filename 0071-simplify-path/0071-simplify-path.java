// chatgpt
// class Solution {
//     public String simplifyPath(String path) {
//         Deque<String> stack = new LinkedList<>();
//         String[] components = path.split("/");
        
//         for (String component : components) {
//             if (component.equals("..")) {
//                 if (!stack.isEmpty()) {
//                     stack.pop();
//                 }
//             } else if (!component.isEmpty() && !component.equals(".")) {
//                 stack.push(component);
//             }
//         }
//         StringBuilder simplifiedPath = new StringBuilder();
//         while (!stack.isEmpty()) {
//             simplifiedPath.append("/").append(stack.pollLast());
//         }
        
//         if (simplifiedPath.length() == 0) {
//             simplifiedPath.append("/");
//         }
        
//         return simplifiedPath.toString();
//     }
// }


//https://www.youtube.com/watch?v=8fM6D3sMIDs

//Stack
//SC -> O(n)
//TC -> O(n)
// class Solution {
//     public String simplifyPath(String path){
//         Stack<String> s = new Stack<>();
//         StringBuilder res = new StringBuilder();
//         String[] p = path.split("/");
        
//         for(int i =0 ; i < p.length; i++){
//             if(!s.isEmpty() && p[i].equals(".."))
//                 s.pop();
//             else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
//                 s.push(p[i]);
//         }
        
//         if(s.isEmpty()) return "/";
//         while(!s.isEmpty()){
//             res.insert(0, s.pop()).insert(0, "/");
//         }
        
//         return res.toString();
//     }
// }


//Deque
//SC -> O(n)
//TC -> O(n)
class Solution {
    public String simplifyPath(String path){
        Deque<String> s = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");
        
        for(int i =0 ; i < p.length; i++){
            if(!s.isEmpty() && p[i].equals(".."))
                s.poll();
            else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }
        
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            res.append("/").append(s.pollLast());
        }
        
        return res.toString();
    }
}