class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        visited.add(x + "," + y);

        for (char direction : path.toCharArray()) {
            if (direction == 'N') {
                y += 1;
            } else if (direction == 'S') {
                y -= 1;
            } else if (direction == 'E') {
                x += 1;
            } else if (direction == 'W') {
                x -= 1;
            }

            String currentPos = x + "," + y;
            if (visited.contains(currentPos)) {
                return true;
            }

            visited.add(currentPos);
        }

        return false;
    }
}