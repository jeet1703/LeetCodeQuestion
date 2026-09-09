class Solution {
    public void bfs(int i , int j, char[][] grid,int[][] visited){
        Queue<int[]> q = new LinkedList<>();
        int[] t = {i,j};
        q.add(t);
        visited[i][j] = 1;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            System.out.println("rc" + r  + " " + c); 
            int[][] dir = {
                {-1,0},
                {0,-1},
                {1,0},
                {0,1}
            };
            for(int a = 0;a<4;a++){
                int nI = r+dir[a][0];
                int nJ = c+dir[a][1];
                if((nI >=0 &&  nI<grid.length) && (nJ >=0 && nJ<grid[0].length) && grid[nI][nJ] == '1' && visited[nI][nJ] != 1){
                    System.out.println("index" + nI + " " + nJ + " " + grid[nI][nJ]); 
                    int[] newTemp = {nI,nJ};
                    visited[nI][nJ] = 1;
                    q.add(newTemp);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count =0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    System.out.println("bfs at " + i + " " + j);
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
}