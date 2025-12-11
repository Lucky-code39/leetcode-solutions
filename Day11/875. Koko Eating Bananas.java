class Solution {
    public int minEatingSpeed(int[] piles, int h) {

         int low = 1;
        int high = 0;
       
        for(int element : piles){
          high = Math.max(element, high);
        }

        while(low < high){
            int mid = low + (high - low) / 2;

            if(canFinish(piles, mid, h)){
                high = mid;
            }
            else{
                low = mid + 1;
            }

            
        }
        return low;
    }

        private boolean canFinish(int[] piles, int mid, int h){
            int time = 0;
            for(int element : piles){
                time = time + (int)Math.ceil((double)element / mid);
                if(time > h){
                return false;
            }
            }
            return time <= h;
            
        }

       

       

    }
