package problems;

import problems.problem237.Cell;
import problems.problem237.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem237BaseCase {
    public static final Cell A = Cell.A;
    public static final Cell B = Cell.B;
    public static final Cell C = Cell.C;
    public static final Cell D = Cell.D;
    public static final Cell E = Cell.E;
    public static final Cell F = Cell.F;

    public static void main(String[] args) {
        getColumns();

        System.out.println(starts.size() + " " + middles.size() + " " + ends.size());

        for(Column start : starts) {
            recurse(start, Arrays.asList(start));
        }
    }


    static int count = 0;
    private static void recurse(Column last, List<Column> columns) {
        if (columns.size() == 9) {
            for(Column end : ends) {
                if (end.fitsRightOf(last)) {
                    List<Column> newColumns = new ArrayList<Column>(columns);
                    newColumns.add(end);
                    print(newColumns);
                    System.out.println(++count);
                    System.out.println("++++++++++++++");
                }
            }
            return;
        }
        for(Column middle : middles) {
            if (middle.fitsRightOf(last)) {
                List<Column> newColumns = new ArrayList<Column>(columns);
                newColumns.add(middle);
                recurse((middle.ID == 0 ? last : middle), newColumns);
            }
        }
    }

    public static List<Column> starts = new ArrayList<Column>();
    public static List<Column> middles = new ArrayList<Column>();
    public static List<Column> ends = new ArrayList<Column>();

    public static void getColumns() {
        int endId = -1;
        int id = 0;
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

                        Column col = new Column(new Cell[] {a, b, c, d}, id);
                        int right = col.rightCount();
                        int left = col.leftCount();
                        if ((left == 2 || left == 4) && (right == 2 || right == 4)) {
                            middles.add(col);
                            id++;
                        }
                        if (right == 0) {
                            ends.add(new Column(new Cell[]{a, b, c, d}, endId--));
                        }
                        if (left == 2 && (right == 2 || right == 4) && a.draw[0].charAt(0) == '_' && d.draw[0].charAt(0) == '_') {
                            starts.add(col);
                        }
                    }
                }
            }
        }
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
