class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int weight : weights){
        low = Math.max(low, weight);
        high += weight;
        }

        while(low < high){
            int mid = low + (high - low) / 2;

            if(canCapacity(weights, mid, days)){
               high = mid; 
        }
        else{
            low = mid + 1;
        }
        
    }
    return low;

    }
    private boolean canCapacity(int[] weights, int mid, int days){
        int usedDays = 1;
        int countDays = 0;

        for(int weight : weights){
            if(countDays + weight > mid){
                usedDays++;
                countDays = 0;
            }
            countDays += weight;

            if(usedDays > days) return false;
        }
        return true;
    }
}