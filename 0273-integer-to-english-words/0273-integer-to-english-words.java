class Solution
{
     public String digit3(List<Integer> d, int start) {
        if (start >= d.size())
            return "";
        int one = d.get(start);
        if (start + 1 == d.size())
            return oneToWord(one);

        int ten = d.get(start + 1);
        String ret = "";

        if (ten == 1) {
            ret = tenToNineteen(one);
        } else {
            ret = oneToWord(one);
            if (one != 0 && ten != 0)
                ret = " " + ret;
            ret = tenToNinety(ten) + ret;
        }

        if (start + 2 == d.size() || d.get(start + 2) == 0)
            return ret;

        if (ten != 0 || one != 0)
            ret = " " + ret;

        int hundred = d.get(start + 2);
        ret = "Hundred" + ret;

        ret = oneToWord(hundred) + " " + ret;

        return ret;
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        List<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }

        String ret = digit3(digits, 0);
        String thousand = digit3(digits, 3);
        String mil = digit3(digits, 6);
        String bil = digit3(digits, 9);

        if (!ret.isEmpty() && !thousand.isEmpty())
            ret = " " + ret;
        if (!thousand.isEmpty())
            ret = thousand + " Thousand" + ret;
        if (!ret.isEmpty() && !mil.isEmpty())
            ret = " " + ret;
        if (!mil.isEmpty())
            ret = mil + " Million" + ret;
        if (!ret.isEmpty() && !bil.isEmpty())
            ret = " " + ret;
        if (!bil.isEmpty())
            ret = bil + " Billion" + ret;
        return ret.trim();
    }

    private String oneToWord(int num) {
        switch (num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }

    private String tenToNineteen(int num) {
        switch (num) {
            case 0: return "Ten";
            case 1: return "Eleven";
            case 2: return "Twelve";
            case 3: return "Thirteen";
            case 4: return "Fourteen";
            case 5: return "Fifteen";
            case 6: return "Sixteen";
            case 7: return "Seventeen";
            case 8: return "Eighteen";
            case 9: return "Nineteen";
            default: return "";
        }
    }

    private String tenToNinety(int num) {
        switch (num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            default: return "";
        }
    }
}

            