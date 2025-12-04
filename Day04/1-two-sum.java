class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
        int current = nums[i];
        int partner = target - current;

        if(map.containsKey(partner)){
        return new int[]{map.get(partner), i};
        }

        map.put(current, i);
        }
        return new int[0];
        
    }
}