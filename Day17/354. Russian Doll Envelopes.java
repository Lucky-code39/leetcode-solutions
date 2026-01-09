class Solution {
    public int maxEnvelopes(int[][] envelopes) {
         if(envelopes.length == 0) return 0;

         Arrays.sort(envelopes, (a, b) -> {
           if(a[0] == b[0]){
            return b[1] - a[1];
            }//height desecding for the same width
            return a[0] - b[0] ;//width in ascending orders
           
         });

         int[] tails = new int[envelopes.length];
         int size = 0;

         for(int[] num : envelopes){
            int h = num[1];

            int left = 0, right = size;
            

            while(left < right){
                int mid = left + (right - left) / 2;
                if(tails[mid] < h){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }

            tails[left] = h;
            if(left == size) size++;
         }
         return size;
    }
}
