class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        for(char c : t.toCharArray()){
            need[c]++;
        }

        int required = 0;//number of distinct elements required
        for(int element : need){
            if(element > 0) required++;
        }

        int formed = 0, left = 0, right = 0, minLength = Integer.MAX_VALUE, minStart = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            window[c]++;
            if(window[c] == need[c]) formed++;

            while(formed == required){//our current window has all the characters required so valid window and shrinking the window
                if(right - left + 1 < minLength){
                   minLength = right - left + 1;
                   minStart = left;
                }

                char lc = s.charAt(left);
                window[lc]--;
                

                if(window[lc] < need[lc]){ 
                    formed--;
                }

                left++;

            }

            right++;

            
            
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);




    }
}