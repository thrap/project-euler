package problems;

public class Problem237 {
    private static enum Direction {
        A(" | ",
          " | "),

        B("___",
          "   "),

        C("_| ",
          "   "),

        D(" |_",
          "   "),

        E("_  ",
          " | "),

        F("  _",
          " | ");

        String[] draw;
        Direction(String... draw) {
            this.draw = draw;
        }
    }

    public static final Direction A = Direction.A;
    public static final Direction B = Direction.B;
    public static final Direction C = Direction.C;
    public static final Direction D = Direction.D;
    public static final Direction E = Direction.E;
    public static final Direction F = Direction.F;

    public static void main(String[] args) {
        Direction[][] board = {
            {B, B, E, F, B, B, B, E, F, E},
            {F, E, D, C, F, B, B, C, A, A},
            {A, A, F, E, D, B, B, B, C, A},
            {C, D, C, D, B, B, B, B, B, C},
        };

        print(board);
    }

    private static void print(Direction[][] board) {
        for(int j = 0; j < board.length; j++) {
            for(int i = 0; i < board[0].length; i++) {
                System.out.print(board[j][i].draw[0]);
            }
            System.out.println();
            for(int i = 0; i < board[0].length; i++) {
                System.out.print(board[j][i].draw[1]);
            }
            System.out.println();
        }
    }
}
