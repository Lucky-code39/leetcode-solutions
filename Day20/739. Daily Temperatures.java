class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];
        int currIndex = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            currIndex = i;
            
            while(!stack.isEmpty() && temperatures[currIndex] > temperatures[stack.peek()]){
               answer[stack.peek()] = currIndex - stack.pop();
            }

            stack.push(currIndex);
        }
        return answer;

    }
}
