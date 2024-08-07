class Solution
{
     private static final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num)
    {
          if(num == 0)
          {
              return "Zero";
          }
        int i = 0;
        String words = "";
        while(num > 0)
        {
            if(num % 1000 != 0)
            {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        
        return words.trim();
    }
    
    private static String helper(int num)
    {
        if (num == 0)
        {
            return "";
        } 
        else if (num < 20)
        {
            return LESS_THAN_TWENTY[num] + " ";
        }
        else if (num < 100)
        {
            return TENS[num / 10] + " " + helper(num % 10);
        }
        else
        {
            return LESS_THAN_TWENTY[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}

            