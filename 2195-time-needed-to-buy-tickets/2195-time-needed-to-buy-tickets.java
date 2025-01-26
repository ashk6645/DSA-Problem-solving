class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int timeElapsed = 0;
        for(int i=0; i<tickets.length; i++){
            if(i<=k){
                timeElapsed += Math.min(tickets[k], tickets[i]);
            }
            else{
                timeElapsed += Math.min(tickets[k]-1, tickets[i]);
            }
        }
        return timeElapsed;  
    }
}