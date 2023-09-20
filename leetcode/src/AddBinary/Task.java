package AddBinary;

public class Task {
    public static void main(String[] args) {

        System.out.println(new Task().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int carry = 0;

        String res = "";

        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            int p = i < len1 ? a.charAt(len1 - 1 - i) - '0' : 0;
            int q = i < len2 ? b.charAt(len2 - 1 - i) - '0' : 0;
            int tmp = p + q + carry;

            carry = tmp / 2;
            res = tmp % 2 + res;
        }
        return (carry == 0) ? res : "1" + res;

//        int first = Integer.parseInt(a,2);
//        int second = Integer.parseInt(b,2);
//        int sum = first + second;
//
//        return Integer.toBinaryString(sum);
    }

}
