/*
integer between 1 and 3999
*/
public class IntToRoman {
    public String intToRoman(int A) {
        String result = ""; //temporary result
        int[] nums = new int[4];
        nums[0] = A % 10;
        nums[1] = A % 100 - nums[0];
        nums[2] = A % 1000 - nums[1] - nums[0];
        nums[3] = A % 10000 - nums[2] - nums[1] - nums[0];
        // System.out.println(nums[3] + " + " + nums[2] + " + " + nums[1] + " +
        // " + nums[0]);
        HashMap<Integer, Character> roman = new HashMap<Integer, Character>();
        roman.put(1, 'I');
        roman.put(5, 'V');
        roman.put(10, 'X');
        roman.put(50, 'L');
        roman.put(100, 'C');
        roman.put(500, 'D');
        roman.put(1000, 'M');

        HashMap<Character, Integer> romantoInt = new HashMap<Character, Integer>();
        romantoInt.put('I', 1);
        romantoInt.put('V', 5);
        romantoInt.put('X', 10);
        romantoInt.put('L', 50);
        romantoInt.put('C', 100);
        romantoInt.put('D', 500);
        romantoInt.put('M', 1000);
        
        //get result in terms of powers of 10
        for (int i = 3; i >= 0; i--) {
            int pow = (int) (Math.pow(10, i));
            int n = nums[i] / pow;
            while (n > 0) {
                result += roman.get(pow);
                n--;
            }
        }
        //System.out.println(result);
        String result1 = "";
        
        //construct final result from the temporary result
        int i = 0;
        while (i < result.length()) {
            char curr = result.charAt(i);
            int count = 0;
            int start=i;
            while (i < result.length() && result.charAt(i) == curr) {
                i++;
                count++;
            }
            if (count < 4) {
                result1 += result.substring(start, i);
                // chuck it
            } else if (count == 4) {
                result1 += curr;
                result1 += roman.get(romantoInt.get(curr) * 5);
            } else if (count < 9) {
                result1 += roman.get(romantoInt.get(curr) * 5);
                count -= 5;
                while(count>0){
                    result1 += curr;
                    count--;
                }
            } else if (count == 9) {
                result1 += curr;
                result1 += roman.get(romantoInt.get(curr) * 10);
            } else {

            }
        }
        //System.out.println(result1);
        return result1;
    }
}
