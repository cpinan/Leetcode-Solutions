/**
 * https://leetcode.com/problems/making-a-large-island/
 */
class Solution {
    
    private static final int[] dX = {-1, 1, 0, 0};
    private static final int[] dY = {0, 0, -1, 1};
    
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] componentMap = new int[m][n];
        int[][] componentSize = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        int componentId = 1;
        int answer = 0;
            
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(!visited[row][col] && grid[row][col] == 1) {
                    // Connect components
                    List<int[]> componentCellList = new ArrayList<>(); // row, col
                    int size = connectComponent(
                        grid,
                        visited,
                        m,
                        n,
                        row,
                        col,
                        componentCellList
                    );
                    
                    for(int[] children : componentCellList) {
                        componentSize[children[0]][children[1]] = size;
                        componentMap[children[0]][children[1]] = componentId;
                    }
                    
                    componentId++;
                    answer = Math.max(answer, size);
                }
            }
        }
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 0) {
                    int size = getSize(
                        componentMap,
                        componentSize,
                        m,
                        n,
                        row, 
                        col
                    );
                    answer = Math.max(answer, size);
                }
            }
        }
        
        return answer;
        
    }
    
    private int getSize(
        int[][] componentMap,
        int[][] componentSize,
        int m,
        int n,
        int row,
        int col
    ) {
        int size = 1;
        Set<Integer> used = new HashSet<>();
        
        for(int i = 0; i < 4; i++) {
            int nextRow = row + dY[i];
            int nextCol = col + dX[i];
            
            if(isSafe(m, n, nextRow, nextCol) && 
               componentMap[nextRow][nextCol] > 0 && 
               !used.contains(componentMap[nextRow][nextCol])) {
                
                used.add(componentMap[nextRow][nextCol]);
                size += componentSize[nextRow][nextCol];
                
            }
            
        }
        
        return size;
    }
    
    private int connectComponent(
        int[][] grid,
        boolean[][] visited,
        int m,
        int n,
        int row, 
        int col,
        List<int[]> componentCellList
    ) {
        if(!isSafe(m, n, row, col) || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }
        int[] cell = {row, col};
        componentCellList.add(cell);
        visited[row][col] = true;
        
        int count = 1;
        
        count += connectComponent(grid, visited, m, n, row - 1, col, componentCellList);
        count += connectComponent(grid, visited, m, n, row + 1, col, componentCellList);
        count += connectComponent(grid, visited, m, n, row, col - 1, componentCellList);
        count += connectComponent(grid, visited, m, n, row, col + 1, componentCellList);
        
        return count;        
    }
    
    private boolean isSafe(
        int m,
        int n,
        int row,
        int col
    ) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}