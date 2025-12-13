class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> List = new ArrayList<>();
        
        int[] need = new int[128];
        int[] window = new int[128];

        
        for(char c : p.toCharArray()){
            need[c]++;
        }

       int required = 0;
        for(int element : need){
            if(element > 0) required++;
        }

        int left = 0, right = 0, sameLetter =  0;

        while(right < s.length()){
            char ch = s.charAt(right);
            window[ch]++;

            if(need[ch] > 0 && window[ch] == need[ch]){
                sameLetter++;
            }

            if(right - left + 1 > p.length()){
                
                char lc = s.charAt(left);
                
                if(window[lc] == need[lc]){
                        sameLetter--;
                }
                window[lc]--;
                

                left++;
            }

             if(sameLetter == required && right - left + 1 == p.length()){
                List.add(left);
            }

    


       right++;

        }
        
        return List;
        
    }
}
