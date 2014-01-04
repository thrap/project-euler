package problems;

import problems.problem237.Column;
import problems.problem237.ColumnGenerator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Problem237 {

    public static List<Column> starts = new ArrayList<Column>();
    public static List<Column> middles = new ArrayList<Column>();
    public static List<Column> ends = new ArrayList<Column>();

    private static class Board {
        private Column left;
        private Column right;
        private final int length;
        BigInteger count;

        public Board(Column column) {
            this.count = BigInteger.ONE;
            this.length = 0;
            this.left = column;
            this.right = column;
        }

        public Board(Board left, Board right) {
            this.count = (left.count.multiply(right.count)).mod(BigInteger.TEN.pow(8));
            this.length = left.length +right.length;
            this.left = (left.left.ID == 0 ? right.left : left.left);
            this.right = (right.right.ID == 0 ? left.right : right.right);
        }

        public boolean fitsRigthOf(Board left) {
            return this.left.fitsRightOf(left.right);
        }

        @Override
        public boolean equals(Object o) {
            Board other = (Board)o;
            return other.left == this.left && other.right == this.right && this.length == other.length;
        }
    }

    public static void main(String[] args) {
        Map<String, List<Column>> lists = new ColumnGenerator().getColumns();
        starts = lists.get("starts");
        middles = lists.get("middles");
        ends = lists.get("ends");

        for(Column a : middles) {
            addColumn(a, Arrays.asList(a));
        }

        long limit = (long)Math.pow(10, 12);

        List<Board>[] boards = new ArrayList[(int)(Math.log(limit)/Math.log(2))+1];
        boards[0] = new ArrayList<Board>();
        for(Column a : middles) {
            boards[0].add(new Board(a));
        }

        for (int i = 1; i < boards.length; i++) {
            boards[i] = extendBoards(boards[i-1], boards[i-1]);
        }

        List<Board> board = new ArrayList<Board>(boards[0]);

        long asd = limit-3;
        for(int exp = boards.length; exp >= 0; exp--) {
            double pow = Math.pow(2, exp);
            if (pow <= asd) {
                board = extendBoards(board, boards[exp]);
                asd -= pow;
            }
        }
        BigInteger sum = BigInteger.ZERO;

        for (Column start : starts) {
            for(Board middle : board) {
                if (!middle.fitsRigthOf(new Board(start)))
                    continue;
                for (Column end : ends) {
                    if (new Board(end).fitsRigthOf(middle)) {
                        sum = sum.add(middle.count);
                    }
                }
            }
        }
        System.out.println(sum.mod(BigInteger.TEN.pow(8)));
    }

    private static List<Board> extendBoards(List<Board> lefts, List<Board> rights) {
        List<Board> result = new ArrayList<Board>();
        for (Board left : lefts) {
            for (Board right : rights) {
                if (right.fitsRigthOf(left)) {
                    Board board = new Board(left, right);
                    boolean added = false;
                    for(Board four : result) {
                        if (four.equals(board)) {
                            four.count = four.count.add(board.count);
                            added = true;
                        }
                    }
                    if (!added)
                        result.add(new Board(left, right));
                }
            }
        }
        return result;
    }

    static int count = 0;
    private static void addColumn(Column last, List<Column> columns) {
        if (columns.size() == 8) {
            count++;
        } else {
            for(Column middle : middles) {
                if (middle.fitsRightOf(last)) {
                    List<Column> newColumns = new ArrayList<Column>(columns);
                    newColumns.add(middle);
                    addColumn((middle.ID == 0 ? last : middle), newColumns);
                }
            }
        }
    }
}
