class Solution {
    public int longestConsecutive(int[] nums) {
       int longestConsecutive = 0;
       HashSet<Integer> set = new HashSet<>();
       for(int num : nums){
        set.add(num);
       }

       for(int num : set){
        ;
          if(!set.contains(num - 1)){
           int length = 1;
           int currentNum = num;

            while(set.contains(currentNum + 1)){
                length++;
                currentNum++;
            }

          longestConsecutive = Math.max(longestConsecutive, length);


          }

       }
       return longestConsecutive;
        
    }
}
