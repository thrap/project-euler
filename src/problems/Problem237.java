package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem237 {
    private static enum Cell {
        A(" | ",
          " | "),

        B("_ _",
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
        Cell(String... draw) {
            this.draw = draw;
        }

        public boolean fitsAbove(Cell o) {
            return this.draw[1].charAt(1) == o.draw[0].charAt(1);
        }

        public boolean fitsBelow(Cell o) {
            return o.fitsAbove(this);
        }
    }

    public static final Cell A = Cell.A;
    public static final Cell B = Cell.B;
    public static final Cell C = Cell.C;
    public static final Cell D = Cell.D;
    public static final Cell E = Cell.E;
    public static final Cell F = Cell.F;

    public static void main(String[] args) {
        List<Cell[]> board = Arrays.asList(new Cell[]{B, F, A, C}, new Cell[]{B, E, A, D});
        List<Cell[]> possible = new ArrayList<Cell[]>();
        for(Cell a : Cell.values()) {
            if (!a.fitsBelow(B))
                continue;
            for(Cell b : Cell.values()) {
                if (!b.fitsBelow(a))
                    continue;
                for(Cell c : Cell.values()) {
                    if (!c.fitsBelow(b))
                        continue;
                    for(Cell d : Cell.values()) {
                        if (!d.fitsBelow(c) || !d.fitsAbove(B))
                            continue;
                        Cell[] column = {a, b, c, d};
                        possible.add(column);
                    }
                }
            }
        }
        print(possible);
    }

    private static void print(List<Cell[]> board) {
        for(int j = 0; j < 4; j++) {
            for(int k = 0; k <= 1; k++) {
                for(int i = 0; i < board.size(); i++) {
                    System.out.print(board.get(i)[j].draw[k]);
                }
                System.out.println();
            }
        }
    }
}
