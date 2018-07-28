/*
Guaranteed that the gievn roman numeral is valid
*/
public class RomanToInt {
    public int romanToInt(String A) {
        if (A == "")
            return 0;
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int result = 0;
        char prev = '0', next;
        for (int i = 0; i < A.length(); i++) {
            next = A.charAt(i);
            if (prev != '0') {
                if (roman.get(prev) < roman.get(next))
                    result += roman.get(next) - 2 * roman.get(prev);
                else
                    result += roman.get(next);
            } else
                result += roman.get(next);
            prev = next;
        }
        return result;
    }
}
