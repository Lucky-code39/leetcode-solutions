class Solution {
    public int mostWordsFound(String[] sentences) {
        int compare = Integer.MIN_VALUE;
        for(int i = 0; i < sentences.length; i++){
            int space = 1;
            String s = sentences[i];
            for(char element : s.toCharArray()){
              
              if(element == ' '){
               space++;
              }
              if(space > compare){
                compare = space;
              }
            }
        }
        return compare;
    }
}