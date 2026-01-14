class Solution {
    public boolean isValid(String s) {
       
       ArrayDeque<Character> dq = new ArrayDeque<>();



        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == ')'){
                if(dq.isEmpty() || dq.getLast() != '('){
                  return false;
                }
                 dq.removeLast();
            }

            else if(s.charAt(i) == '}'){
                if(dq.isEmpty() || dq.getLast() != '{'){
                   return false;
                }
                dq.removeLast();
            }

            else if(s.charAt(i) == ']'){
                if(dq.isEmpty() || dq.getLast() != '['){
                    return false;
                }
                dq.removeLast();
            }

           else{ //opening bracket
                dq.addLast(s.charAt(i));
            }
            
        }
        
         return dq.isEmpty();
        
    }
}
