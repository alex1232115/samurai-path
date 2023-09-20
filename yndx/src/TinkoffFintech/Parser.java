package TinkoffFintech;

public class Parser {
    public static void main(String[] args) throws Exception {
        MatchParserPlusMinus matchParserPlusMinus = new MatchParserPlusMinus();
        System.out.println(matchParserPlusMinus.Parse("1+2*3*5"));
    }
}
class Result{
    public int acc;
    public String rest;

    public Result(int acc, String rest)
    {
        this.acc = acc;
        this.rest = rest;
    }
}
class MatchParserPlusMinus {
    public MatchParserPlusMinus(){}

    public int Parse(String s) throws Exception {
        Result result = PlusMinus(s);
        if (!result.rest.isEmpty()){
            System.out.println("WRONG");
            System.out.println("rest: " + result.rest);
        }
        return result.acc;
    }

    private Result PlusMinus(String s) throws Exception {
        Result current = Num(s);
        int acc = current.acc;

        while (current.rest.length() > 0){
            char sign = current.rest.charAt(0);
            if (!((sign == '+') || sign == '-' || sign == '*')) break;

            String next = current.rest.substring(1);

            current = Num(next);
            if (sign == '+'){
                acc += current.acc;
            } else if (sign == '*'){
                acc *= current.acc;
            } else {
                acc -= current.acc;
            }
            current.acc = acc;
        }
        return new Result(current.acc, current.rest);
    }

    private Result Num(String s) throws Exception{
        int i = 0;
        int dot_cnt = 0;
        boolean negative = false;

        if (s.charAt(0) == '-'){
            negative = true;
            s = s.substring(1);
        }
        while (i < s.length() && (Character.isDigit(s.charAt(i)))){
            i++;
        }
        if (i == 0){
            throw new Exception("WRONG");
        }
        int iPart = Integer.parseInt(s.substring(0, i));
        if (negative) iPart = -iPart;
        String restPart = s.substring(i);

        return new Result(iPart, restPart);
    }
}
