class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int original = image[sr][sc];
        if(original == color) return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        image[sr][sc] = color;

        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];

            for(int i = 0; i < 4; i++){
                int nr = r + rows[i];
                int nc = c + cols[i];

                if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length){
                    if(image[nr][nc] == original){
                        queue.add(new int[]{nr, nc});
                        image[nr][nc] = color;
                    }
                }
            }
        }

        return image;




    }
}
