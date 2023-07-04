class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");
        
        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }
        StringBuilder simplifiedPath = new StringBuilder();
        while (!stack.isEmpty()) {
            simplifiedPath.append("/").append(stack.pollLast());
        }
        
        if (simplifiedPath.length() == 0) {
            simplifiedPath.append("/");
        }
        
        return simplifiedPath.toString();
    }
}