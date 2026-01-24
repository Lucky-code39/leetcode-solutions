class Solution {
    public int sumSubarrayMins(int[] arr) {
         int n = arr.length;
        int MOD = 1_000_000_007;

        int[] ple = new int[n];
        int[] nse = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nse[i] - i;
            result = (result + arr[i] * left % MOD * right % MOD) % MOD;
        }

        return (int) result;
        
    }
}