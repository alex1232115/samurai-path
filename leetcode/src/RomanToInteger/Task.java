package RomanToInteger;

import java.util.Hashtable;

public class Task {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        ht.put("M", 1000);
        ht.put("D", 500);
        ht.put("C", 100);
        ht.put("L", 50);
        ht.put("X", 10);
        ht.put("V", 5);
        ht.put("I", 1);

        int output = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (4* ht.get(String.valueOf(s.charAt(i))) < output) {
                num = ht.get(String.valueOf(s.charAt(i)));
                output -= num;
            } else {
                num = ht.get(String.valueOf(s.charAt(i)));
                output += num;
            }
        }
        return output;


        //1 вариант
//        for (int i = s.length() - 1; i >= 0; i--) {// i-- Выполняется после тела цикла на каждой итерации перед проверкой условия.
//            String number = String.valueOf(s.charAt(i));
//            String nextNumber = String.valueOf(s.charAt(i - 1));
//            if (ht.get(number) > ht.get(nextNumber)) output -= ht.get(nextNumber);

        //думал сделать через switch, заебался подстраивать условия
//            switch (number) {
//                case ("V"):
//                    if (String.valueOf(s.charAt(i - 1)).matches("I")) {
//                        output+=ht.get("V")-ht.get("I");
//                        --i;
//                    }else{
//                        output+=ht.get("V");
//                    }
//                    break;
//                case ("L"):
//                    if (String.valueOf(s.charAt(i - 1)).matches("X")) {
//                        output+=ht.get("L")-ht.get("X");
//                        --i;
//                    }else{
//                        output+=ht.get("L");
//                    }
//                    break;
//                case ("D"):
//                    if (String.valueOf(s.charAt(i - 1)).matches("C")) {
//                        output+=ht.get("D")-ht.get("C");
//                        --i;
//                    }else{
//                        output+=ht.get("D");
//                    }
//                    break;
//                case ("M"):
//                    if (String.valueOf(s.charAt(i - 1)).matches("C")) {
//                        output+=ht.get("M")-ht.get("C");
//                        --i;
//                    }else{
//                        output+=ht.get("M");
//                    }
//                    break;
//                case ("I"):
//                    output+=ht.get("I");
//                    break;
//                case ("X"):
//                    if (String.valueOf(s.charAt(i - 1)).matches("I")) {
//                        output+=ht.get("X")-ht.get("I");
//                        --i;
//                    }else{
//                        output+=ht.get("X");
//                    }
//                    break;
//                case ("C"):
//                    if (String.valueOf(s.charAt(i - 1)).matches("X")) {
//                        output+=ht.get("C")-ht.get("X");
//                        --i;
//                    }else{
//                        output+=ht.get("C");
//                    }
//                    break;
//            }
//            if (ht.containsKey(a)) {
//
//                if ((a.contains("I") && b.contains("V"))){output += ht.get(a);
//            }
    }
}
