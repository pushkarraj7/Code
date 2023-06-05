class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(course).add(prerequisiteCourse);
        }
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, visited, i)) {
                return false; // Cycle detected, course schedule is not possible
            }
        }
        return true; // No cycle detected, course schedule is possible
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) {
            return true;
        }
        if (visited[course] == -1) {
            return false;
        }        
        visited[course] = 1;
        
        for (int prerequisite : graph.get(course)) {
            if (hasCycle(graph, visited, prerequisite)) {
                return true;
            }
        }
        
        visited[course] = -1;
        return false;
    }
}