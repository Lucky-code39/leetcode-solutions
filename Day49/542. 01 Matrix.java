class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
                else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] rows = {-1, 1, 0, 0};
        int[] columns = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int column = node[1];

            for(int i = 0; i < 4; i++){
                int tr = row + rows[i];
                int tc = column + columns[i];
                if(tr >= 0 && tr < mat.length && tc >= 0 && tc < mat[0].length){
                   if(mat[tr][tc] > mat[row][column] + 1){
                    mat[tr][tc] = mat[row][column] + 1;
                    queue.add(new int[]{tr, tc});
                }
                }
                
            }
        }

        return mat;
    }
}
