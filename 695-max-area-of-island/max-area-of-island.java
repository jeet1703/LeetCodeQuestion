class Solution {
    public int solve(int[][] grid,int[][] visited,int iIdx , int jIdx){
        int[][] dir = new int[][]{new int[]{-1,0},new int[]{1,0},new int[]{0,-1},new int[]{0,1}};
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{iIdx,jIdx});
        visited[iIdx][jIdx] = 1;
        int count =1;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i =0;i<4;i++){
                int t1=  temp[0] + dir[i][0];
                int t2 = temp[1] + dir[i][1];
                if((t1>=0 && t1<grid.length) && (t2>=0 && t2<grid[0].length) && grid[t1][t2] == 1 && visited[t1][t2] != 1){
                    visited[t1][t2] = 1;
                    count++;
                    q.add(new int[]{t1,t2});
                }
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        int[][] visited = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1 && visited[i][j] != 1){
                    int countArea = solve(grid,visited,i,j);
                    maxArea = Math.max(maxArea,countArea);
                }
            }
        }
        return maxArea;
    }
}