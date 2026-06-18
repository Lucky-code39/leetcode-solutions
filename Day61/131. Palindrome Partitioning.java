class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());
        return result;
    }

    public void dfs(int start, String s, List<String> partition){
        if(s.length() == start) result.add(new ArrayList<>(partition));

        for(int end = start; end < s.length(); end++){

            if(isPalindrome(s, start, end)){
                partition.add(s.substring(start, end + 1));

                dfs(end + 1, s, partition);

                partition.remove(partition.size() - 1);
            }

           
        }

       
    }
     public boolean isPalindrome(String s, int left, int right){
          
          while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
          }
          return true;
        }
}