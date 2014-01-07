package problems;

public class Problem259 {

    private static enum Operator {
        NOTHING(""), ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

        private String c;
        Operator(String c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c;
        }
    }

    public static void main(String[] args) {
        asd(2, "1");
        System.out.println(count);

        System.out.println(parse("(1+2)/3+(45*678)-9"));
    }

    private static int parse(String s) {


        return 0;
    }

    static int count = 0;

    private static void asd(int i, String ops) {
        if (i == 10) {
            System.out.println(ops);
            count++;
        } else {
            for(Operator op : Operator.values()) {
                asd(i+1, ops + op.toString() + i);
            }
        }
    }
}
