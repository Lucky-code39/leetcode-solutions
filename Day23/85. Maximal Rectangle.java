class Solution {
    public int maximalRectangle(char[][] matrix) {
    
    int rows = matrix.length;
    int cols = matrix[0].length;

    int[] heights = new int[cols];
    int maxArea = 0;
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            if(matrix[i][j] == '1'){
                heights[j]++;
            }
            else{
                heights[j] = 0;
            }
        }
        maxArea = Math.max(maxArea, largestRectangle(heights));
    }

        return maxArea;
    
    
    }
    private int largestRectangle(int[] heights){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for(int i = 0; i <= heights.length; i++){
            int currHeight = (i == heights.length) ? 0 : heights[i];
            int right = i;

            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                max = Math.max(max, height * width);
            }

            stack.push(i);
        }
        return max;
    }
}
