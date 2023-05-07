class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // Build the adjacency list and the in-degree array
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            adjList.get(preReq).add(course);
            inDegree[course]++;
        }
        // Add all courses with 0 in-degree to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[index++] = course;
            // Decrement the in-degree of all courses dependent on the current course
            for (int i = 0; i < adjList.get(course).size(); i++) {
                int dependentCourse = adjList.get(course).get(i);
                if (--inDegree[dependentCourse] == 0)
                    queue.offer(dependentCourse);
            }
        }
        // If all courses have been added to the result, return the result
        return (index == numCourses) ? res : new int[0];
    }
}