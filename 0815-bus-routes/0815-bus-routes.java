class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        int busChanges = 0;
        
        queue.offer(source);
        visitedStops.add(source);
        
        while (!queue.isEmpty()) {
            int stopsInLevel = queue.size();
            busChanges++;
            
            for (int i = 0; i < stopsInLevel; i++) {
                int stop = queue.poll();
                List<Integer> routesAtStop = stopToRoutes.getOrDefault(stop, new ArrayList<>());
                
                for (int route : routesAtStop) {
                    if (visitedRoutes.contains(route)) continue;
                    visitedRoutes.add(route);
                    
                    for (int nextStop : routes[route]) {
                        if (visitedStops.contains(nextStop)) continue;
                        
                        if (nextStop == target) return busChanges;
                        
                        visitedStops.add(nextStop);
                        queue.offer(nextStop);
                    }
                }
            }
        }
        
        return -1; // No path found
    }
}