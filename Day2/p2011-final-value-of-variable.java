class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;

        for(int i = 0; i < operations.length; i++){
            char ch = operations[i].charAt(1);
 
      if(ch == '+'){
            X++;
        }
      else if(ch == '-'){
            X--;
        }
        
        }
       

        return X;
    }
}