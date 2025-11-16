class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffleArr = new int[nums.length];

            int increment = 0;
        for(int i = 0; i < nums.length; i++){
            if( i%2 == 0){
                shuffleArr[i] = nums[increment];
                increment++;
            }
            else{
                shuffleArr[i] = nums[n];
                n = n + 1;
            }

        }
        return shuffleArr;
    }
}