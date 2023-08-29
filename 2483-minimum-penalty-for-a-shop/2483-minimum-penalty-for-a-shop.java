class Solution 
{
    public int bestClosingTime(String customers)
    {
         int minPenalty = 0, curPenalty = 0;
        int earliestHour = 0;

        for (int i = 0; i < customers.length(); i++)
        {
            char ch = customers.charAt(i);
            
           
            if (ch == 'Y')
            {
                curPenalty--;
            }
            else
            {
                curPenalty++;
            }

            
            if (curPenalty < minPenalty) 
            {
                earliestHour = i + 1;
                minPenalty = curPenalty;
        
             }
        }
        return earliestHour;
    }
}



