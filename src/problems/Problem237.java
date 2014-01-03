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

    private static class Column {
        Cell[] column;

        public Column(Cell[] column) {
            this.column = column;
        }

        public int leftCount() {
            int count = 0;
            for(Cell c : column) {
                if (c.draw[0].charAt(0) == '_')
                    count++;
            }
            return count;
        }

        public int rightCount() {
            int count = 0;
            for(Cell c : column) {
                if (c.draw[0].charAt(2) == '_')
                    count++;
            }
            return count;
        }

        public boolean fitsRight(Column col) {
            for(int i = 0; i < 4; i++) {
                if (column[i].draw[0].charAt(0) != col.column[i].draw[0].charAt(2))
                    return false;
            }
            return true; 
        }
    }

    public static final Cell A = Cell.A;
    public static final Cell B = Cell.B;
    public static final Cell C = Cell.C;
    public static final Cell D = Cell.D;
    public static final Cell E = Cell.E;
    public static final Cell F = Cell.F;

    public static void main(String[] args) {
        List<Column> possible = new ArrayList<Column>();
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
                        if ((a == F && b == D && c == E && d == C) || (a == E && b == C && c == F && d == D))
                            continue; // Special case
                        Column col = new Column(new Cell[] {a, b, c, d});
                        int right = col.rightCount();
                        int left = col.leftCount();
                        if ((left == 2 || left == 4) && (right == 2 || right == 4))
                            possible.add(col);
                    }
                }
            }
        }

        for(Column col1 : possible) {
            print(Arrays.asList(col1));
            System.out.println("+++++++++++++");
        }
        System.out.println(possible.size());
    }

    private static void print(List<Column> board) {
        for(int j = 0; j < 4; j++) {
            for(int k = 0; k <= 1; k++) {
                for(int i = 0; i < board.size(); i++) {
                    System.out.print(board.get(i).column[j].draw[k]);
                }
                System.out.println();
            }
        }
    }
}
